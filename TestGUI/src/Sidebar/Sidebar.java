package Sidebar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Sidebar extends JFrame {
    private JPanel sidebar;
    private final int SIDEBAR_COLLAPSED_WIDTH = 50;
    private final int SIDEBAR_EXPANDED_WIDTH = 200;
    private boolean isExpanded = false;

    public Sidebar() {
        this.setTitle("Expandable Sidebar Example");
        this.setSize(600, 400);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout());
        this.sidebar = new JPanel();
        this.sidebar.setBackground(Color.DARK_GRAY);
        this.sidebar.setPreferredSize(new Dimension(50, this.getHeight()));
        this.sidebar.setLayout(new BoxLayout(this.sidebar, 1));
        JLabel iconLabel = new JLabel("\ud83c\udfe0", 0);
        iconLabel.setForeground(Color.WHITE);
        iconLabel.setAlignmentX(0.5F);
        this.sidebar.add(Box.createVerticalStrut(20));
        this.sidebar.add(iconLabel);
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.add(new JLabel("Main Content Area"));
        this.sidebar.addMouseListener(new MouseAdapter() {
            {
                Objects.requireNonNull(Sidebar.this);
            }

            public void mouseEntered(MouseEvent e) {
                Sidebar.this.expandSidebar();
            }

            public void mouseExited(MouseEvent e) {
                if (!Sidebar.this.sidebar.getBounds().contains(e.getPoint())) {
                    Sidebar.this.collapseSidebar();
                }

            }
        });
        this.add(this.sidebar, "West");
        this.add(contentPanel);
        this.setVisible(true);
    }

    private void expandSidebar() {
        if (!this.isExpanded) {
            this.sidebar.setPreferredSize(new Dimension(200, this.getHeight()));
            this.sidebar.revalidate();
            this.isExpanded = true;
        }

    }

    private void collapseSidebar() {
        if (this.isExpanded) {
            this.sidebar.setPreferredSize(new Dimension(50, this.getHeight()));
            this.sidebar.revalidate();
            this.isExpanded = false;
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Sidebar::new);
    }
}
