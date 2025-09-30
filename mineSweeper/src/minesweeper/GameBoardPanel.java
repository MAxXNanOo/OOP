package minesweeper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static minesweeper.MineSweeperConstants.*;

public class GameBoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public static final int CELL_SIZE = 60;
    public static final int CANVAS_WIDTH = CELL_SIZE * COLS;
    public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;

    Cell[][] cells = new Cell[ROWS][COLS];
    int numMines = 10;
    boolean gameOver = false;

    public GameBoardPanel() {
        super.setLayout(new GridLayout(ROWS, COLS, 2, 2));

        // [TODO 3]
        CellMouseListener listener = new CellMouseListener();

        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                cells[row][col] = new Cell(row, col);
                super.add(cells[row][col]);

                // [TODO 4]
                cells[row][col].addMouseListener(listener);
            }
        }

        super.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
    }

    public void newGame() {
        gameOver = false;

        MineMap mineMap = new MineMap();
        mineMap.newMineMap(numMines);

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                cells[row][col].newGame(mineMap.isMined[row][col]);
            }
        }
    }

    private int getSurroundingMines(int srcRow, int srcCol) {
        int numMines = 0;
        for (int row = srcRow - 1; row <= srcRow + 1; row++) {
            for (int col = srcCol - 1; col <= srcCol + 1; col++) {
                if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                    if (cells[row][col].isMined) numMines++;
                }
            }
        }
        return numMines;
    }

    private void revealCell(int srcRow, int srcCol) {
        if (cells[srcRow][srcCol].isRevealed || cells[srcRow][srcCol].isFlagged)
            return;

        int numMines = getSurroundingMines(srcRow, srcCol);
        Cell cell = cells[srcRow][srcCol];

        cell.setText(numMines == 0 ? "" : String.valueOf(numMines));
        cell.isRevealed = true;
        cell.paint();

        if (numMines == 0) {
            for (int row = srcRow - 1; row <= srcRow + 1; row++) {
                for (int col = srcCol - 1; col <= srcCol + 1; col++) {
                    if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                        revealCell(row, col);
                    }
                }
            }
        }
    }

    public boolean hasWon() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Cell c = cells[row][col];
                if (!c.isMined && !c.isRevealed) {
                    return false;
                }
            }
        }
        return true;
    }

    // [TODO 2]
    private class CellMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (gameOver) return;

            Cell cell = (Cell)e.getSource();

            if (SwingUtilities.isLeftMouseButton(e)) {
                if (cell.isMined) {
                    cell.setText("*");
                    cell.setForeground(Color.RED);
                    cell.paint();
                    gameOver = true;
                    JOptionPane.showMessageDialog(null, "Game Over!");
                } else {
                    revealCell(cell.row, cell.col);
                }
            } else if (SwingUtilities.isRightMouseButton(e)) {
                if (!cell.isRevealed) {
                    if (cell.isFlagged) {
                        cell.setText("");
                        cell.isFlagged = false;
                    } else {
                        cell.setText("F");
                        cell.isFlagged = true;
                    }
                    cell.paint();
                }
            }

            if (hasWon() && !gameOver) {
                gameOver = true;
                JOptionPane.showMessageDialog(null, "You Win!");
            }
        }
    }
}
