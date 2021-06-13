package View;

import Controller.Driver;
import Model.Book;
import Model.User;
import Model.Order;

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

    protected OrderTableModel orderTableModel;
    protected CustomJTable orderCustomTableModel;
    public void viewPlaceOrdersPanel(){
        orderTableModel = new OrderTableModel();
        orderCustomTableModel = new CustomJTable(placeOrdersPanel,orderTableModel);
    }



    public void viewPromoteUsersPanel(){

    }

    public void viewReportsPanel(){

    }


    public void viewFindABookPanel(){
        super.viewFindABookPanel();
        JButton addBookButton, deleteBookButton, newBookButton, placeOrderButton , modifyBookButton;
        addBookButton = new JButton("add Book");
        modifyBookButton = new JButton("modify Book");
        deleteBookButton = new JButton("delete Book");
        newBookButton = new JButton("new Book");
        placeOrderButton = new JButton("place order");
        addBookButton.setEnabled(false);
        newBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bookTableModel.newBook();
                bookTableModel.setSelectedCell(bookTableModel.getRowCount()-1);
                modifyBookButton.setEnabled(false);
                placeOrderButton.setEnabled(false);
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
        modifyBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(modifyBookButton.getText().equals("modify Book")) {
                    if(bookCustomJTable.getTable().getSelectedRow() == -1) return;
                    modifyBookButton.setText("save");
                    placeOrderButton.setEnabled(false);
                    addBookButton.setEnabled(false);
                    newBookButton.setEnabled(false);
                    bookTableModel.setSelectedCell(bookCustomJTable.getTable().getSelectedRow());
                }else{
                    modifyBookButton.setText("modify Book");
                    Book modifiedBook = bookTableModel.getCertainBook(bookTableModel.getSelectedCell());
                    bookTableModel.setSelectedCell(-1);
                    placeOrderButton.setEnabled(true);
                    addBookButton.setEnabled(true);
                    newBookButton.setEnabled(true);
                }
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

        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(bookCustomJTable.getTable().getSelectedRow() == -1) return;
                Book selectedBook = bookTableModel.getCertainBook(bookCustomJTable.getTable().getSelectedRow());
                Order order = new Order("",selectedBook.getISBN(),"","1",selectedBook.getPrice());
                orderTableModel.newOrder(order);
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
