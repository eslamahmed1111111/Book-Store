package View;

import Controller.Driver;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInView extends Frame{


    private Driver driver;
    public SignInView() {
        super("Sign In");
        driver = new Driver();
    }

    public void view() {

        JPanel books_panel1 = new JPanel();
        JPanel books_panel2 = new JPanel();
        JPanel books_panel3 = new JPanel();
        JPanel books_panel4 = new JPanel();

        getMainPanel().setBorder(new EmptyBorder(new Insets(50,200,200,200)) );
        books_panel1.setBorder(new EmptyBorder(new Insets(50,20,50,20)) );
        books_panel2.setBorder(new EmptyBorder(new Insets(50,20,50,20)) );
        books_panel3.setBorder(new EmptyBorder(new Insets(50,20,50,20)) );
        books_panel4.setBorder(new EmptyBorder(new Insets(50,20,50,20)) );

        BoxLayout boxlayout = new BoxLayout(getMainPanel(), BoxLayout.Y_AXIS);
        BoxLayout boxlayout1 = new BoxLayout(books_panel1, BoxLayout.X_AXIS);
        BoxLayout boxlayout2 = new BoxLayout(books_panel2, BoxLayout.X_AXIS);
        BoxLayout boxlayout3 = new BoxLayout(books_panel3, BoxLayout.X_AXIS);
        BoxLayout boxlayout4 = new BoxLayout(books_panel4, BoxLayout.X_AXIS);

        JLabel label1 = new JLabel("Welcome to BookStore!");
        label1.setFont(new Font("Courier",Font.BOLD,50));
        label1.setSize(300,100);
        books_panel1.add(label1);

        JLabel label2 = new JLabel("Username  ");
        label2.setFont(new Font("Courier",Font.PLAIN,25));
        label2.setSize(100,50);
        JTextField text2 = new JTextField();
        books_panel2.add(label2);
        books_panel2.add(text2);

        JLabel label3 = new JLabel("Password  ");
        label3.setFont(new Font("Courier",Font.PLAIN,25));
        label2.setSize(100,50);
        JTextField text3 = new JTextField();
        books_panel3.add(label3);
        books_panel3.add(text3);

        JButton bt1 = new JButton("Log in");
        bt1.setFont(new Font("Courier",Font.BOLD,15));
        bt1.setSize(900,700);
        JButton bt2 = new JButton("Register");
        bt2.setFont(new Font("Courier",Font.BOLD,15));
        bt2.setSize(900,700);

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(driver.signIn(label1.getText(),label2.getText())){
                    getFrame().setVisible(false);
                    new CustomerView("home page").view();
                }
            }
        });

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                SingUpView singUpView = new SingUpView();
                singUpView.view();
            }
        });

        books_panel4.add(bt1);
        books_panel4.add(bt2);

        getMainPanel().setLayout(boxlayout);
        books_panel1.setLayout(boxlayout1);
        books_panel2.setLayout(boxlayout2);
        books_panel3.setLayout(boxlayout3);
        books_panel4.setLayout(boxlayout4);

        getMainPanel().add(books_panel1);
        getMainPanel().add(books_panel2);
        getMainPanel().add(books_panel3);
        getMainPanel().add(books_panel4);


        getFrame().add(getMainPanel());
        getFrame().pack();

    }

}
