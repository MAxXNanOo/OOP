
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;


public class Calculator extends JFrame implements ActionListener{
    private JButton [] button = new JButton[20];

    private String [] stringbutton = {
                                        "C", "CE" ,"/" , "*" ,
                                        "7" , "8" , "9" , "-" ,
                                        "4" , "5" , "6" , "+" ,
                                        "1" , "2" , "3" , "=" ,
                                        "0", "0" , "." , "="    };


    JLabel labelbefore = new JLabel(" ");
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

                if(stringbutton[Index].matches("[1-9]")) {
                    button[Index].addActionListener(new ActionListener() {
                        int IndexButton = Index;
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if(labelsum.getText().matches("[0,+,--,*,/]")) {
                                    labelsum.setText("");
                                }
                                labelbefore.setText(labelbefore.getText() + button[IndexButton].getText());
                                labelsum.setText(labelsum.getText() + button[IndexButton].getText());
                        }

                    });
                }
                else if(stringbutton[Index].equals("C")) {
                    button[Index].addActionListener(e -> {
                        labelbefore.setText("");
                        labelsum.setText("0");
                    });
                }
                else if(stringbutton[Index].equals("CE")) {
                    button[Index].addActionListener(e -> {
                        String tmp = labelbefore.getText().replace(labelsum.getText(), "");
                        labelbefore.setText(tmp);
                        labelsum.setText("0");
                    });
                }
                else{
                    int IndexButton = Index; // ล็อกค่า Index ไว้ก่อน

                    button[IndexButton].addActionListener(e -> {
                        if(!labelsum.getText().matches("[0,+,--,*,/]") ) {
                            String tmp = button[IndexButton].getText();
                            labelbefore.setText(labelbefore.getText() + tmp);
                            labelsum.setText(tmp);
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
        button[16].addActionListener(e -> {
            if(labelsum.getText().matches("[0,+,--,*,/]")) {
                labelsum.setText("0");
            }
            else{
                if(labelsum.getText().equals("0")) {
                    labelsum.setText("");
                }
                labelsum.setText(labelsum.getText() + button[16].getText());
                labelbefore.setText(labelbefore.getText() + button[16].getText());
            }
        });

        c.gridx = 2;
        c.gridy = 6;
        c.gridwidth = 1;
        pane.add(button[18] = new JButton(stringbutton[18]), c);
        setButtonStyle(button[18]);
        button[18].addActionListener(e -> {
            if(labelsum.getText().matches("0")) {
                labelbefore.setText(labelbefore.getText() + "0.");
            }
            else{
                labelbefore.setText(labelbefore.getText() + ".");
            }

            labelsum.setText(labelsum.getText() + button[18].getText());
        });

        c.gridx = 3;
        c.gridy = 5;
        c.gridheight = 2;
        pane.add(button[19] = new JButton(stringbutton[19]), c);
        setButtonStyle(button[19]);
        button[19].setForeground(grayColor);
        button[19].setBackground(new Color(90, 180, 250));
        button[19].addActionListener(e -> {
            char [] arr = labelbefore.getText().toCharArray();
            char [] tmp = new char[arr.length];
            String [] arr2 = new String[arr.length];

            int Index=-1, sizeNumber = -1;
            for(int i=0 ; i<arr.length ; i++) {
                if(arr[i]!='+' && arr[i]!='-' && arr[i]!='*' && arr[i]!='/'){
                    tmp[++Index] = arr[i];
                }
                else{
                    arr2[++sizeNumber] = new String(tmp).trim();
                    arr2[++sizeNumber] = new String(String.valueOf(arr[i])).trim();
                    tmp =  new char[arr.length];
                    Index = -1;
                }
            }
            arr2[++sizeNumber] = new String(tmp).trim();


            System.out.printf("\n\n\n\n");
            for( ; sizeNumber>-1 ; sizeNumber--){
                System.out.println(arr2[sizeNumber]);
            }



            //รอทำ prefix เเละ postfix
//            double [] numbers = new double[sizeNumber];
//            int topNumber = -1;
//            for(int i=0 ; i<=sizeNumber ; i++){
//                if(arr2[i].matches("[+,--,*,/]")){
//                    switch(arr2[i]){
//                        case "+":
//                            top
//                    }
//                }
//                else{
//                   numbers[++topNumber] = Double.parseDouble(arr2[i]);
//                }
//            }

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
    }

    public static void main(String[] args) {
        new Calculator("Calculator");
    }
}
