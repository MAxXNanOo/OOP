package Lab14.Store.minesweeper;

import static Lab14.Store.minesweeper.MineSweeperConstants.COLS;
import static Lab14.Store.minesweeper.MineSweeperConstants.ROWS;

import java.util.Random;

public class MineMap {
    
    // เปลี่ยนเป็น private เพื่อ Encapsulation
    private int numMines;
    private boolean[][] isMined = new boolean[ROWS][COLS];

    // Constructor (ไม่จำเป็นต้องมี super() เพราะสืบทอดจาก Object)
    public MineMap() {
    }
    
    /** Public getter to check if a cell contains a mine */
    public boolean isMined(int row, int col) {
        // ใช้ Getter เพื่อให้ GameBoardPanel เข้าถึงข้อมูล
        return isMined[row][col];
    }

    /** Generates a new mine map with the specified number of mines */
    public void newMineMap(int numMines) {
        this.numMines = numMines;
        
        // 1. Reset the map (สำคัญ!)
        // สร้างอาเรย์ใหม่เพื่อให้แน่ใจว่าทุกช่องถูกเซ็ตเป็น false 
        isMined = new boolean[ROWS][COLS]; 
        
        Random rand = new Random();
        int minesToPlace = numMines;
        
        while(minesToPlace > 0) {
            int r = rand.nextInt(ROWS);
            int c = rand.nextInt(COLS);
            
            // 2. วางระเบิดเฉพาะช่องที่ยังไม่มี
            if(!isMined[r][c]) {
                isMined[r][c] = true;
                minesToPlace--;
            }
        }
    }
}