package minesweeper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static minesweeper.MineSweeperConstants.*;

public class GameBoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    // Constants from Cell.java (for convenience/readability, though not strictly needed here)
    public static final int CELL_SIZE = 30; // ลดขนาดเพื่อให้ดูดีขึ้นสำหรับ 20x20
    public static final int CANVAS_WIDTH = CELL_SIZE * COLS;
    public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;

    private Cell[][] cells = new Cell[ROWS][COLS];
    private boolean gameOver = false;
    private MineMap mineMap; 

    public GameBoardPanel() {
        // ใช้ GridLayout โดยไม่มีช่องว่างเพื่อสร้างความรู้สึกเหมือนตารางเดียว
        super.setLayout(new GridLayout(ROWS, COLS)); 
        // ให้สีพื้นหลังเป็นสีเทาเข้มเพื่อให้ตัดกับสีปุ่ม
        super.setBackground(new Color(150, 150, 150)); 
        
        CellMouseListener listener = new CellMouseListener();

        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                cells[row][col] = new Cell(row, col);
                super.add(cells[row][col]);
                cells[row][col].addMouseListener(listener);
            }
        }

        super.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
    }

    /** Reset the game */
    public void newGame() { 
        gameOver = false;

        mineMap = new MineMap();
        // ใช้ค่าคงที่ NUM_MINES จาก MineSweeperConstants
        mineMap.newMineMap(NUM_MINES); 

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                // ใช้ mineMap.isMined(row, col) (Getter)
                cells[row][col].newGame(mineMap.isMined(row, col));
            }
        }
    }

    /** Utility method to get the number of surrounding mines */
    private int getSurroundingMines(int srcRow, int srcCol) {
        int count = 0;
        for (int row = srcRow - 1; row <= srcRow + 1; row++) {
            for (int col = srcCol - 1; col <= srcCol + 1; col++) {
                if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                    // ใช้ isMined() getter
                    if (cells[row][col].isMined()) count++; 
                }
            }
        }
        return count;
    }

    /** Core logic to reveal a cell and its neighbors if it's an empty cell (0 mines) */
    private void revealCell(int srcRow, int srcCol) {
        // ตรวจสอบขอบเขต
        if (srcRow < 0 || srcRow >= ROWS || srcCol < 0 || srcCol >= COLS) return;
        
        Cell cell = cells[srcRow][srcCol];

        // ใช้ getter
        if (cell.isRevealed() || cell.isFlagged()) 
            return;

        // 1. เซ็ตสถานะเป็น Revealed
        cell.setRevealed(true); 

        // 2. คำนวณระเบิดรอบข้าง
        int surroundingMines = getSurroundingMines(srcRow, srcCol);
        
        // 3. วาด Cell
        cell.paint(surroundingMines); 

        // 4. ถ้าเป็นช่องว่าง (0) ให้เปิดเซลล์รอบข้างแบบ Recursive
        if (surroundingMines == 0) {
            for (int row = srcRow - 1; row <= srcRow + 1; row++) {
                for (int col = srcCol - 1; col <= srcCol + 1; col++) {
                    // Recursive call (ไม่รวมตัวเอง)
                    if (row != srcRow || col != srcCol) { 
                        revealCell(row, col);
                    }
                }
            }
        }
    }
    
    /** Reveal all mines and incorrect flags when the game is over (loss) */
    private void revealAllMines(Cell hitCell) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Cell cell = cells[row][col];
                cell.setEnabled(false); // ปิดการใช้งานปุ่มทั้งหมด

                if (cell.isMined()) {
                    if (cell != hitCell) {
                        // เปิดเผยระเบิดที่เหลือ ยกเว้นช่องที่ชนไปแล้ว
                        cell.setRevealed(true); 
                        cell.paint(0);
                        cell.setText("*"); // แสดงเป็นรูประเบิด
                        cell.setForeground(Color.BLACK);
                    }
                } else if (!cell.isMined() && cell.isFlagged()) {
                    // แสดงว่าปักธงผิด
                    cell.setBackground(Color.LIGHT_GRAY);
                    cell.setText("X"); 
                    cell.setForeground(Color.RED);
                }
            }
        }
    }


    /** Check if the player has won (all non-mine cells are revealed) */
    public boolean hasWon() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Cell c = cells[row][col];
                // ถ้าไม่ใช่ระเบิด และยังไม่ถูกเปิด แสดงว่ายังไม่ชนะ
                if (!c.isMined() && !c.isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }

    // Inner class for Mouse Listener
    private class CellMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (gameOver) return;

            Cell cell = (Cell)e.getSource();
            int srcRow = cell.getRow(); 
            int srcCol = cell.getCol(); 
            
            // --- Left Click: Reveal Cell ---
            if (SwingUtilities.isLeftMouseButton(e)) {
                if (cell.isFlagged()) return; 

                if (cell.isMined()) {
                    // Game Over: ชนระเบิด
                    gameOver = true;
                    cell.setRevealed(true); 
                    cell.paint(0); 
                    
                    // เรียกฟังก์ชันเปิดเผยระเบิดทั้งหมด
                    revealAllMines(cell); 
                    
                    JOptionPane.showMessageDialog(null, "Game Over! You hit a mine.");

                } else {
                    // เปิดเผยช่อง
                    revealCell(srcRow, srcCol);
                }

            // --- Right Click: Flag/Unflag Cell ---
            } else if (SwingUtilities.isRightMouseButton(e)) {
                if (!cell.isRevealed()) { 
                    cell.setFlagged(!cell.isFlagged()); // สลับสถานะธง
                    cell.paint(0);
                }
            }
            
            // Check Win Condition
            if (!gameOver && hasWon()) {
                gameOver = true;
                // เมื่อชนะ ให้เปิดเผยธง/ระเบิดที่เหลือ
                revealAllMines(null); 
                JOptionPane.showMessageDialog(null, "You Win! All non-mine cells revealed.");
            }
        }
    }
}