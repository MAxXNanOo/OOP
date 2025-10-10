package Lab14.Store.minesweeper;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton; // นำเข้าสำหรับเส้นขอบ
import javax.swing.border.Border; // นำเข้าสำหรับ Border

public class Cell extends JButton {
    private static final long serialVersionUID = 1L;

    // --- สีพื้นฐาน ---
    public static final Color BG_NOT_REVEALED = new Color(192, 192, 192); // สีเทาอ่อน (มาตรฐาน)
    public static final Color BG_REVEALED = new Color(224, 224, 224);    // สีเทาอ่อนกว่าเมื่อเปิดแล้ว
    public static final Color BG_MINE_HIT = Color.RED;                    // สีแดงเมื่อชนระเบิด

    // --- สีตัวอักษรสำหรับตัวเลข (ตามมาตรฐาน Mine Sweeper) ---
    public static final Color[] FG_NUMBERS = {
        Color.BLUE,         // 1
        new Color(0, 128, 0), // 2 (Dark Green)
        Color.RED,          // 3
        new Color(0, 0, 128), // 4 (Dark Blue)
        new Color(128, 0, 0), // 5 (Dark Red)
        Color.CYAN,         // 6
        Color.BLACK,        // 7
        Color.DARK_GRAY     // 8
    };
    public static final Color FG_FLAG_MINE = Color.BLACK; // ธงและระเบิดใช้สีดำ (สำหรับธง)

    // --- ฟอนต์ ---
    public static final Font FONT_NUMBERS = new Font("SansSerif", Font.BOLD, 18);
    
    // --- เส้นขอบ (Border) ---
    // Border สำหรับเซลล์ที่ยังไม่ถูกเปิด (ดูเหมือนปุ่มนูน)
    private static final Border RAISED_BEVEL = BorderFactory.createRaisedBevelBorder();
    // Border สำหรับเซลล์ที่ถูกเปิดแล้ว (ดูเรียบ)
    private static final Border LOWERED_BEVEL = BorderFactory.createLoweredBevelBorder();


    // Properties (private)
    private int row, col;
    private boolean isRevealed;
    private boolean isMined;
    private boolean isFlagged;

    /** Constructor */
    public Cell(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        setFont(FONT_NUMBERS);
        // ทำให้ปุ่มไม่มีสีเวลา focus
        setFocusPainted(false);
    }
    
    // ... (Getters/Setters ยังคงเดิม) ...
    public int getRow() { return row; }
    public int getCol() { return col; }
    public boolean isRevealed() { return isRevealed; }
    public boolean isMined() { return isMined; }
    public boolean isFlagged() { return isFlagged; }
    public void setFlagged(boolean flagged) { this.isFlagged = flagged; }
    public void setRevealed(boolean revealed) { this.isRevealed = revealed; }


    /** Reset this cell, ready for a new game */
    public void newGame(boolean isMined) {
        this.isRevealed = false;
        this.isFlagged = false;
        this.isMined = isMined;
        setEnabled(true); 
        setText("");
        paint(0);
    }

    /** Paint itself based on its status and surrounding mines count */
    public void paint(int surroundingMines) {
        if (isRevealed) {
            // เซลล์ที่ถูกเปิดแล้ว
            setBorder(LOWERED_BEVEL);
            setBackground(BG_REVEALED);
            setEnabled(false); 

            if (isMined) {
                // ถ้าเป็นระเบิด
                setText("*"); 
                setForeground(FG_FLAG_MINE);
                setBackground(BG_MINE_HIT); // เน้นสีแดงเมื่อระเบิดถูกชน
            } else if (surroundingMines > 0) {
                // ถ้าเป็นตัวเลข
                setText(String.valueOf(surroundingMines));
                // ใช้สีตามอาร์เรย์ FG_NUMBERS (ลบ 1 เพราะ index เริ่มจาก 0)
                setForeground(FG_NUMBERS[surroundingMines - 1]); 
            } else {
                setText(""); // ช่องว่าง
            }

        } else { 
            // เซลล์ที่ยังไม่ถูกเปิด
            setBorder(RAISED_BEVEL);
            setBackground(BG_NOT_REVEALED);
            setEnabled(true);
            
            if (isFlagged) {
                setText("F"); // ธง
                setForeground(FG_FLAG_MINE);
            } else {
                setText(""); // ว่าง
            }
        }
    }
}