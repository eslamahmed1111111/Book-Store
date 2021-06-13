package View;

import Model.Order;
import Model.User;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserTableModel extends AbstractTableModel {
    private String[] cols = {"user_name", "first_name", "last_name",  "email", "phone_number","shipping address"};
    private ArrayList<User> users;
    private Map<String,User> userNameToUser;

    public UserTableModel(){
        users = new ArrayList<>();
        User user = new User("user_name","password", "first_name", "last_name",  "email", "phone_number","shipping address","user");
        users.add(user);
        userNameToUser = new HashMap<>();
        userNameToUser.put(user.getUserName(),user);
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c){
            case 0:
                return users.get(r).getUserName();
            case 1:
                return users.get(r).getFirstName();
            case 2:
                return users.get(r).getLastName();
            case 3:
                return users.get(r).getEmail();
            case 4:
                return users.get(r).getPhoneNumber();
            case 5:
                return users.get(r).getShippingAddress();
        }
        return null;
    }
    public String getColumnName(int c){
        return cols[c];
    }


    public boolean isCellEditable(int row, int col){
        return false;
    }

    public void newCustomerUser(User user){
        users.add(user);
        userNameToUser.put(user.getUserName(),user);
        fireTableDataChanged();
    }


    public void moveToManager(String user_name){
        if(userNameToUser.containsKey(user_name)) users.remove(userNameToUser.get(user_name));
        fireTableDataChanged();
    }

}
