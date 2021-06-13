package View;

import Model.Book;
import Model.Order;
import Model.ShoppingCartItem;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class OrderTableModel extends AbstractTableModel {
    private String[] cols = {"user_name", "ISBN", "order_date",  "quantity", "price"};
    private ArrayList<Order> orders;

    public OrderTableModel(){
        orders = new ArrayList<>();
        orders.add(new Order("user_name", "ISBN", "order_date",  "quantity", "price"));
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c){
            case 0:
                return orders.get(r).getUser_name();
            case 1:
                return orders.get(r).getISBN();
            case 2:
                return orders.get(r).getOrder_date();
            case 3:
                return orders.get(r).getQuantity();
            case 4:
                return orders.get(r).getPrice();
        }
        return null;
    }
    public String getColumnName(int c){
        return cols[c];
    }
    public void setValueAt(Object value, int r, int c){
        if (c == 5){
            orders.get(r).setQuantity((String) value);
        }
        fireTableCellUpdated(r,c);
    }

    public boolean isCellEditable(int row, int col){
        return false;
    }

    public void newOrder(Order order){
        if(orders.contains(order)) orders.get(orders.indexOf(order)).setQuantity(String.valueOf(Integer.parseInt(orders.get(orders.indexOf(order)).getQuantity())+1));
        else orders.add(order);
        fireTableDataChanged();
    }

}
