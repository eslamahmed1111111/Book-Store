package View;

import Model.Book;
import Model.ShoppingCartItem;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ShoppingCartTableModel extends AbstractTableModel {
    private int id;
    private String[] cols = {"ISBN", "title", "publisher",  "category", "price", "quantity"};
    private ArrayList<ShoppingCartItem> shoppingCarts;

    public ShoppingCartTableModel(){
        id = 0;
        shoppingCarts = new ArrayList<>();
        shoppingCarts.add(new ShoppingCartItem("id","us","sdf","fsd","Fsd","fsd","df","df","fd","fd","fd"));
    }

    @Override
    public int getRowCount() {
        return shoppingCarts.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c){
            case 0:
                return shoppingCarts.get(r).getISBN();
            case 1:
                return shoppingCarts.get(r).getBook().getTitle();
            case 2:
                return shoppingCarts.get(r).getBook().getPublisher();
            case 3:
                return shoppingCarts.get(r).getBook().getCategory();
            case 4:
                return shoppingCarts.get(r).getBook().getPrice();
            case 5:
                return shoppingCarts.get(r).getQuantity();
        }
        return null;
    }
    public String getColumnName(int c){
        return cols[c];
    }
    public void setValueAt(Object value, int r, int c){
        if (c == 5){
            shoppingCarts.get(r).setQuantity((String) value);
        }
        fireTableCellUpdated(r,c);
    }

    public boolean isCellEditable(int row, int col){
        return col == 5;
    }

    public void newBook(Book book){
        if(shoppingCarts.contains(book)) shoppingCarts.get(shoppingCarts.indexOf(book)).setQuantity(shoppingCarts.get(shoppingCarts.indexOf(book)).getQuantity()+1);
        else shoppingCarts.add(new ShoppingCartItem(book.getISBN(),getId(),"1",book.getTitle(),book.getPublisher(),book.getAuthor(),book.getPublicationYear(),book.getPrice(),book.getCategory(),book.getNumOfCopies(),book.getThresholdQuantity()));
        fireTableDataChanged();
    }
    public String getId(){
        id++;
        return String.valueOf(id);
    }
    public void deleteBook(int index){
        if(index == -1) return;
        shoppingCarts.remove(index);
        fireTableDataChanged();
    }


}
