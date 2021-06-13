package View;

import Model.Book;
import Model.ShoppingCart;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ShoppingCartTableModel extends AbstractTableModel {
    private String[] cols = {"ISBN", "title", "publisher",  "category", "price", "quantity"};
    private ArrayList<ShoppingCart> shoppingCarts;

    public ShoppingCartTableModel(){
        shoppingCarts = new ArrayList<>();
        shoppingCarts.add(new ShoppingCart("id","us","sdf","fsd","Fsd","fsd"));
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
                return shoppingCarts.get(r).getTitle();
            case 2:
                return shoppingCarts.get(r).getPublisher();
            case 3:
                return shoppingCarts.get(r).getCategory();
            case 4:
                return shoppingCarts.get(r).getPrice();
            case 5:
                return shoppingCarts.get(r).getQuantity();
        }
        return null;
    }
    public String getColumnName(int c){
        return cols[c];
    }
    public void setValueAt(Object value, int r, int c){
        switch (c){
            case 0:
                shoppingCarts.get(r).setISBN((String) value);
                break;
            case 1:
                shoppingCarts.get(r).setTitle((String) value);
                break;
            case 2:
                shoppingCarts.get(r).setPublisher((String) value);
                break;
            case 3:
                shoppingCarts.get(r).setCategory((String) value);
                break;
            case 4:
                shoppingCarts.get(r).setPrice((String) value);
                break;
            case 5:
                shoppingCarts.get(r).setQuantity((String) value);
                break;
        }
        fireTableCellUpdated(r,c);
    }

    public boolean isCellEditable(){
        return false;
    }

    public void newBook(Book book){
        if(shoppingCarts.contains(book)) shoppingCarts.get(shoppingCarts.indexOf(book)).setQuantity(shoppingCarts.get(shoppingCarts.indexOf(book)).getQuantity()+1);
        else shoppingCarts.add(new ShoppingCart(book.getISBN(),book.getTitle(),book.getPublisher(),book.getCategory(),book.getPrice(),"1"));
        fireTableDataChanged();
    }
    public void deleteBook(int index){
        if(index == -1) return;
        shoppingCarts.remove(index);
        fireTableDataChanged();
    }


}
