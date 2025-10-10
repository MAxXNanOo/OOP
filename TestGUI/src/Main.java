import Sidebar.Sidebar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public Main() {
        setTitle("CardLayout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // จัดให้อยู่กลางจอ

        JPanel panel = new JPanel();
        JButton button = new JButton("Click Me");
        panel.add(button);





        // สร้าง sidebar
        JPanel sidebar = new JPanel();
        sidebar.setBackground(Color.DARK_GRAY);
        sidebar.setPreferredSize(new Dimension(50, getHeight()));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        // เพิ่ม icon หรือปุ่มจำลอง
        JLabel iconLabel = new JLabel("🏠", SwingConstants.CENTER);
        iconLabel.setForeground(Color.WHITE);
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(Box.createVerticalStrut(20)); // ระยะห่างด้านบน
        sidebar.add(iconLabel);
        sidebar.addMouseListener(new MouseAdapter() {
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




        add(sidebar,  BorderLayout.WEST);
        add(panel);


        setVisible(true);
    }





    public static void main(String[] args) {
        // เรียกใช้ GUI ใน Event Dispatch Thread
        SwingUtilities.invokeLater(Main::new);
    }
}
