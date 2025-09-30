package minesweeper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    private static final long serialVersionUID = 1L;

    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");

    public Main() {
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        // เพิ่มปุ่ม New Game ที่ด้านล่าง
        JPanel southPanel = new JPanel();
        southPanel.add(btnNewGame);
        cp.add(southPanel, BorderLayout.SOUTH);

        btnNewGame.addActionListener(e -> board.newGame());

        board.newGame();

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}

