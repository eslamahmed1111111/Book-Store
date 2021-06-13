package View;

import Controller.Driver;
import Model.User;

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
        getMainPanel().setLayout(new BoxLayout(getMainPanel(),BoxLayout.Y_AXIS));

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Courier",Font.PLAIN,25));
        usernameLabel.setSize(100,50);
        JTextField usernameTextField = new JTextField();
        getMainPanel().add(getPairLayouts(usernameLabel,usernameTextField));

        JLabel firstNameLabel = new JLabel("First name");
        firstNameLabel.setFont(new Font("Courier",Font.PLAIN,25));
        firstNameLabel.setSize(100,50);
        JTextField firstNameTextField = new JTextField();

        JLabel lastNameLabel = new JLabel("last name");
        lastNameLabel.setFont(new Font("Courier",Font.PLAIN,25));
        lastNameLabel.setSize(100,50);
        JTextField lastNameTextField = new JTextField();

        getMainPanel().add(getPairLayouts(getPairLayouts(firstNameLabel,firstNameTextField),
                getPairLayouts(lastNameLabel,lastNameTextField)));


        JLabel passwordLabel = new JLabel("password");
        passwordLabel.setFont(new Font("Courier",Font.PLAIN,25));
        passwordLabel.setSize(100,50);
        JTextField passwordTextField = new JTextField();
        getMainPanel().add(getPairLayouts(passwordLabel,passwordTextField));

        JLabel emailLabel = new JLabel("email");
        emailLabel.setFont(new Font("Courier",Font.PLAIN,25));
        emailLabel.setSize(100,50);
        JTextField emailTextField = new JTextField();
        getMainPanel().add(getPairLayouts(emailLabel,emailTextField));

        JLabel phoneNumberLabel = new JLabel("phone number");
        phoneNumberLabel.setFont(new Font("Courier",Font.PLAIN,25));
        phoneNumberLabel.setSize(100,50);
        JTextField phoneNumberTextField = new JTextField();
        getMainPanel().add(getPairLayouts(phoneNumberLabel,phoneNumberTextField));


        JLabel shippingAddressLabel = new JLabel("shipping address");
        shippingAddressLabel.setFont(new Font("Courier",Font.PLAIN,25));
        shippingAddressLabel.setSize(100,50);
        JTextField shippingAddressTextField = new JTextField();
        getMainPanel().add(getPairLayouts(shippingAddressLabel,shippingAddressTextField));




        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Courier",Font.BOLD,15));
        signUpButton.setSize(900,700);
        getMainPanel().add(signUpButton);


        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                User user = new User(usernameTextField.getText(),passwordTextField.getText(),firstNameTextField.getText(),
                        lastNameTextField.getText(),emailTextField.getText(),phoneNumberTextField.getText(),shippingAddressTextField.getText(),"customer");
                Driver driver = new Driver();
                driver.signUp(user);
                new CustomerView("home page").view();
            }
        });
        getFrame().add(getMainPanel());
        getFrame().pack();
    }
}
