package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends Frame{

    public UserView(String title) {
        super(title);
    }

    /**
     *  edit profile
     *  search for books --> dialog(add to shopping cart)
     *  view && checkout shopping cart --> dialog.
     */
    private JPanel findABookPanel, editProfilePanel, shoppingCartPanel;

    private void init(){
        editProfilePanel = new JPanel();
        findABookPanel = new JPanel();
        shoppingCartPanel = new JPanel();
    }


    public void viewFindABookPanel(){

    }


    public void viewEditProfilePanel(){
        editProfilePanel.setLayout(new BoxLayout(editProfilePanel,BoxLayout.Y_AXIS));
        String firstName = "islam";
        String lastName = "yousry";
        String email = "is";
        String phoneNumber = "04";
        String shippingAddress = "dfs";
        JLabel firstNameLabel = new JLabel("First Name");
        JLabel lastNameLabel = new JLabel("Last Name");
        JLabel emailLabel = new JLabel("Email");
        JLabel phoneNumberLabel = new JLabel("Phone Number");
        JLabel shippingAddressLabel = new JLabel("Shipping Address");

        JTextField firstNameTextField = new JTextField(firstName);
        firstNameTextField.setEnabled(false);
        JTextField lastNameTextField = new JTextField(lastName);
        lastNameTextField.setEnabled(false);
        JTextField emailTextField = new JTextField(email);
        emailTextField.setEnabled(false);
        JTextField phoneNumberTextField = new JTextField(phoneNumber);
        phoneNumberTextField.setEnabled(false);
        JTextField shippingAddressTextField = new JTextField(shippingAddress);
        shippingAddressTextField.setEnabled(false);
        editProfilePanel.add(getPairLayouts(firstNameLabel,firstNameTextField));
        editProfilePanel.add(getPairLayouts(lastNameLabel,lastNameTextField));
        editProfilePanel.add(getPairLayouts(emailLabel,emailTextField));
        editProfilePanel.add(getPairLayouts(phoneNumberLabel,phoneNumberTextField));
        editProfilePanel.add(shippingAddressLabel,shippingAddressTextField);

        JButton saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        JButton editButton = new JButton("edit");
        editProfilePanel.add(getPairLayouts(editButton,saveButton));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editButton.setEnabled(true);
                saveButton.setEnabled(false);
                firstNameTextField.setEnabled(false);
                lastNameTextField.setEnabled(false);
                emailTextField.setEnabled(false);
                phoneNumberTextField.setEnabled(false);
                shippingAddressTextField.setEnabled(false);
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editButton.setEnabled(false);
                saveButton.setEnabled(true);
                firstNameTextField.setEnabled(true);
                lastNameTextField.setEnabled(true);
                emailTextField.setEnabled(true);
                phoneNumberTextField.setEnabled(true);
                shippingAddressTextField.setEnabled(true);
            }
        });
    }

    public void viewShoppingCartPanel(){

    }

    public void view(){
        init();
        JTabbedPane tabbedPane = new JTabbedPane();
        setMainPanel(tabbedPane);
        tabbedPane.setBorder(BorderFactory.createLineBorder(Color.black));
        tabbedPane.addTab("find a book",findABookPanel);
        tabbedPane.addTab("profile",editProfilePanel);
        tabbedPane.addTab("shopping cart",shoppingCartPanel);
       viewFindABookPanel();
       viewEditProfilePanel();
       viewShoppingCartPanel();
       getFrame().add(getMainPanel());
       getFrame().pack();
    }

}
