package View;

import Controller.Driver;
import Model.Book;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerView extends UserView {
    public ManagerView(String title){
        super(title);
    }

    public Driver drive = new Driver();

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
        JButton addBookButton, deleteBookButton, newBookButton, placeOrderButton;
        addBookButton = new JButton("add Book");
        deleteBookButton = new JButton("delete Book");
        newBookButton = new JButton("new Book");
        addBookButton.setEnabled(false);
        newBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bookTableModel.newBook();
                bookTableModel.setSelectedCell(bookTableModel.getRowCount()-1);
                addBookButton.setEnabled(true);
                newBookButton.setEnabled(false);
            }
        });
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Book newBook = bookTableModel.getCertainBook(bookTableModel.getRowCount()-1);
                drive.addBook(newBook);
                System.out.println(newBook.toString());
                addBookButton.setEnabled(false);
                newBookButton.setEnabled(true);
                bookTableModel.setSelectedCell(-1);
            }
        });
        deleteBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = bookCustomJTable.getTable().getSelectedRow();
                 Book b = bookTableModel.getCertainBook(row);
                drive.deleteBook(b);
                bookTableModel.deleteBook(row);

            }
        });
        placeOrderButton = new JButton("place order");
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        findABookPanel.add(getPairLayouts(newBookButton,getPairLayouts(getPairLayouts(addBookButton,deleteBookButton),placeOrderButton)));
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
