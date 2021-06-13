package View;

import Model.Book;

import javax.swing.*;
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
        JButton addBookButton, modifyBookButton, deleteBookButton, newBookButton, placeOrderButton;
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
                modifyBookButton.setEnabled(true);
                placeOrderButton.setEnabled(true);
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
                bookTableModel.deleteBook(bookCustomJTable.getTable().getSelectedRow());

            }
        });
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        findABookPanel.add(getPairLayouts(newBookButton,getPairLayouts(getPairLayouts(addBookButton,getPairLayouts(modifyBookButton,deleteBookButton)),placeOrderButton)));
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
