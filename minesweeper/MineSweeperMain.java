package Lab14.Store.minesweeper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Mine Sweeper Game.
 * Left-click to reveal a cell.
 * Right-click to plant/remove a flag for marking a suspected mine.
 * You win if all the cells not containing mines are revealed.
 * You lose if you reveal a cell containing a mine.
 */
public class MineSweeperMain extends JFrame {
    private static final long serialVersionUID = 1L;

    // private variables
    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");

    // Constructor to set up all the UI and game components
    public MineSweeperMain() {
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());

        // 1. Add Game Board to the Center
        cp.add(board, BorderLayout.CENTER);

        // 2. Add btnNewGame to the south
        // แนะนำให้ใส่ปุ่มใน JPanel เพื่อจัดให้อยู่ตรงกลาง
        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.add(btnNewGame);
        cp.add(southPanel, BorderLayout.SOUTH);

        // 3. Add ActionListener for the New Game button
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.newGame(); // เรียกเมธอด newGame() เพื่อเริ่มเกมใหม่
            }
        });

        // 4. Start the first game
        board.newGame();

        // Final Frame setup
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        // Center the window on the screen
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    // The entry main() method
    public static void main(String[] args) {
        // แนะนำให้ใช้ SwingUtilities.invokeLater เพื่อความปลอดภัยในการจัดการเธรด
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MineSweeperMain();
            }
        });
    }
}