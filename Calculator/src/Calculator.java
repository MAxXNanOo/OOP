
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{
    private JButton [] button = new JButton[20];

    private String [] stringbutton = {"C", "CE" ,"/" , "*" ,
            "7" , "8" , "9" , "-" ,
            "4" , "5" , "6" , "+" ,
            "1" , "2" , "3" , "=" ,
            "0", "0" , "." , "=" };

    JLabel labelbefore = new JLabel("");
    JLabel labelsum = new JLabel("0");

    Color grayColor = new Color(40, 40, 40);

    int Index = 0;

    public Calculator(String title) {
        setTitle("Calculator");
        setSize(400,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel pane = new JPanel();
        pane.setOpaque(true);
        pane.setBackground(grayColor);
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;


        c.weightx=1;
        c.weighty=0.2;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridheight = 1;
        labelbefore.setOpaque(true);
        labelbefore.setBackground(grayColor);
//		labelbefore.setBorder(null);
        labelbefore.setPreferredSize(new Dimension(50,10));
        labelbefore.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelbefore.setForeground(new Color(150, 150, 150));
        labelbefore.setHorizontalAlignment(SwingConstants.RIGHT);
        pane.add(labelbefore, c);

        c.weightx=1;
        c.weighty=1;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.gridheight = 1;
        labelsum.setOpaque(true);
        labelsum.setBackground(grayColor);
//		labelsum.setBorder(null);
        labelsum.setFont(new Font("Tahoma", Font.BOLD, 25));
        labelsum.setForeground(new Color(200, 200, 200));
        labelsum.setHorizontalAlignment(SwingConstants.RIGHT);
        pane.add(labelsum, c);

        c.insets = new Insets(1,1,1,1);
        c.weightx=1;
        c.weighty=1;


        c.gridwidth = 1;
        for(int i=2 ; i<=5 ; i++) {
            for(int j=0 ; j<=3 && Index<15 ; j++,Index++) {
                c.gridx = j;
                c.gridy = i;
                button[Index] = new JButton(stringbutton[Index]);
                setButtonStyle(button[Index]);

                if(stringbutton[Index].matches("[0-9]")) {
                    button[Index].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(labelsum.getText().length() == 1  &&  labelsum.getText().equals("0")) {
                                labelsum.setText( button[Index].getText());
                            }
                            else {
                                labelbefore.setText(labelbefore.getText() + button);
                                labelbefore.setText(labelsum.getText() + button);
                            }


                        }

                    });
                }

                pane.add(button[Index], c);
            }
        }


        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        c.gridheight = 1;
        pane.add(button[16] = new JButton(stringbutton[16]), c);
        setButtonStyle(button[16]);

        c.gridx = 2;
        c.gridy = 6;
        c.gridwidth = 1;
        pane.add(button[18] = new JButton(stringbutton[18]), c);
        setButtonStyle(button[18]);

        c.gridx = 3;
        c.gridy = 5;
        c.gridheight = 2;
        pane.add(button[19] = new JButton(stringbutton[19]), c);
        setButtonStyle(button[19]);
        button[19].setForeground(grayColor);
        button[19].setBackground(new Color(90, 180, 250));
        button[19].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                labelbefore.setText(labelbefore.getText() + "nig");

            }
        });




        add(pane);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }


    public  void setButtonStyle(JButton button) {
        button.setFont(new Font("Tahoma",Font.BOLD,16));
        button.setForeground(new Color(200,200,200));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBackground(new Color(70,70,70));
//		button.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mousePressed(java.awt.event.MouseEvent e) {
//				button.setBackground(new Color(20,20,20));
//			}
//			public void mouseReleased(java.awt.event.MouseEvent e) {
//				button.setBackground(new Color(70,70,70));
//			}
//		});
    }

    public static void main(String[] args) {
        new Calculator("Calculator");
    }
}
