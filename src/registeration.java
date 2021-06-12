import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registeration {
    JFrame frame = new JFrame("registeration");

    public registeration() {
        JPanel register  = new JPanel();
        JPanel register1  = new JPanel();
        JPanel register2  = new JPanel();
        JPanel register3  = new JPanel();
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        register.setBorder(new EmptyBorder(new Insets(50,200,200,200)) );
        register1.setBorder(new EmptyBorder(new Insets(50,20,50,20)) );
        register2.setBorder(new EmptyBorder(new Insets(50,20,50,20)) );
        register3.setBorder(new EmptyBorder(new Insets(50,20,50,20)) );
        BoxLayout boxlayout = new BoxLayout(register, BoxLayout.Y_AXIS);
        BoxLayout boxlayout1 = new BoxLayout(register1, BoxLayout.X_AXIS);
        BoxLayout boxlayout2 = new BoxLayout(register2, BoxLayout.X_AXIS);
        BoxLayout boxlayout3 = new BoxLayout(register3, BoxLayout.X_AXIS);

        JLabel label1 = new JLabel("Username  ");
        label1.setFont(new Font("Courier",Font.PLAIN,25));
        label1.setSize(100,50);
        JTextField text1 = new JTextField();
        register1.add(label1);
        register1.add(text1);

        JLabel label2 = new JLabel("Password  ");
        label2.setFont(new Font("Courier",Font.PLAIN,25));
        label2.setSize(100,50);
        JTextField text2 = new JTextField();
        register2.add(label2);
        register2.add(text2);

        JButton bt1 = new JButton("Confirm");
        bt1.setFont(new Font("Courier",Font.BOLD,15));
        bt1.setSize(900,700);

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        JButton bt2 = new JButton("Cancel");
        bt2.setFont(new Font("Courier",Font.BOLD,15));
        bt2.setSize(900,700);

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        register3.add(bt1);
        register3.add(bt2);

        register.setLayout(boxlayout);
        register1.setLayout(boxlayout1);
        register2.setLayout(boxlayout2);
        register3.setLayout(boxlayout3);

        register.add(register1);
        register.add(register2);
        register.add(register3);

        frame.add(register);
        frame.pack();
        frame.setVisible(true);

    }




}
