package View;

import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerView extends UserView {
    public ManagerView(String title){
        super(title);
    }

    private JPanel confirmOrdersPanel, placeOrdersPanel, promoteUsersPanel, reportsPanel;

    private void init(){
        confirmOrdersPanel = new JPanel();
        placeOrdersPanel = new JPanel();
        promoteUsersPanel = new JPanel();
        reportsPanel = new JPanel();
    }


    public void viewConfirmOrdersPanel(){

    }

    public void viewPlaceOrdersPanel(){

    }

    public void viewPromoteUsersPanel(){

    }

    public void viewReportsPanel(){

    }


    public void viewFindABookPanel(){
        super.viewFindABookPanel();
        JButton addBookButton, deleteBookButton;
        addBookButton = new JButton("add Book");
        deleteBookButton = new JButton("delete Book");
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tableModel.newBook();
            }
        });
        deleteBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tableModel.deleteBook(customJTable.getTable().getSelectedRow());
            }
        });

        findABookPanel.add(getPairLayouts(addBookButton,deleteBookButton));
    }

    public void view(){
        init();
        super.view();
        JTabbedPane tabbedPane = (JTabbedPane) getMainPanel();
        tabbedPane.addTab("confirm orders",confirmOrdersPanel);
        tabbedPane.addTab("place orders",placeOrdersPanel);
        tabbedPane.addTab("promote users",promoteUsersPanel);
        tabbedPane.addTab("reports",reportsPanel);
        viewConfirmOrdersPanel();
        viewPlaceOrdersPanel();
        viewPromoteUsersPanel();
        viewReportsPanel();
        getFrame().pack();
    }
}
