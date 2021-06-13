package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingUpView extends Frame{

    public SingUpView() {
        super("Sign Up");
    }

    public void view(){
        setMainPanel(new JPanel());
        getMainPanel().setLayout(new BoxLayout(getMainPanel(),BoxLayout.Y_AXIS));

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Courier",Font.PLAIN,25));
        usernameLabel.setSize(100,50);
        JTextField usernameTextField = new JTextField();
        getMainPanel().add(getPairLayouts(usernameLabel,usernameTextField));

        JLabel firstNameLabel = new JLabel("First name");
        usernameLabel.setFont(new Font("Courier",Font.PLAIN,25));
        usernameLabel.setSize(100,50);
        JTextField firstNameTextField = new JTextField();

        JLabel lastNameLabel = new JLabel("Username  ");
        usernameLabel.setFont(new Font("Courier",Font.PLAIN,25));
        usernameLabel.setSize(100,50);
        JTextField lastNameTextField = new JTextField();

        getMainPanel().add(getPairLayouts(getPairLayouts(firstNameLabel,firstNameTextField),
                getPairLayouts(lastNameLabel,lastNameTextField)));


        JLabel passwordLabel = new JLabel("password");
        usernameLabel.setFont(new Font("Courier",Font.PLAIN,25));
        usernameLabel.setSize(100,50);
        JTextField passwordTextField = new JTextField();
        getMainPanel().add(getPairLayouts(passwordLabel,passwordTextField));

        JLabel emailLabel = new JLabel("email");
        usernameLabel.setFont(new Font("Courier",Font.PLAIN,25));
        usernameLabel.setSize(100,50);
        JTextField emailTextField = new JTextField();
        getMainPanel().add(getPairLayouts(emailLabel,emailTextField));

        JLabel phoneNumberLabel = new JLabel("phone number");
        usernameLabel.setFont(new Font("Courier",Font.PLAIN,25));
        usernameLabel.setSize(100,50);
        JTextField phoneNumberTextField = new JTextField();
        getMainPanel().add(getPairLayouts(phoneNumberLabel,phoneNumberTextField));




        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Courier",Font.BOLD,15));
        signUpButton.setSize(900,700);
        getMainPanel().add(signUpButton);


        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);

            }
        });



    }
}
