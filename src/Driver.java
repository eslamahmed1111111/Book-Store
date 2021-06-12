

import Model.*;

import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;

public class Driver {


	
	public boolean signIn(String userName, String password) {
        Connection myConnection = null;  //address of server
        Statement stmt = null;
        ResultSet res = null;
        boolean b = true;

        String query = "select * from users where user_name = " + userName + "AND password = "
                + password + ";";

        try {
            stmt = myConnection.createStatement();
            res = stmt.executeQuery(query);

            if (res.next()) {
                b = true;
            }
            else {  b = false;  }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return b;
	}

	public void signUp(User u) {
        Connection myConnection = null;  //address of server
        Statement stmt = null;

        String query = "insert into users values( " + u.getUserName() + "," + u.getPassword() + "," +
               u.getFirstName() + "," + u.getLastName() + "," + u.getEmail() + "," +
                u.getPhoneNumber() + "," + u.getShippingAddress() + u.getPrivilege() +  ");";

        try {
            stmt = myConnection.createStatement();
            stmt.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    public void promoteUser(User u){
        Connection myConnection = null;  //address of server
        Statement stmt = null;

        String query = "update users set privilege = 'customer' " +
                       " where user_name = " + u.getUserName() + ";" ;
        try {
            stmt = myConnection.createStatement();
            stmt.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

	public List<Book> searchBook(String s){
       List<Book> books = new ArrayList<>();
       Connection myConnection = null;  //address of server
	    Statement stmt = null;
       ResultSet res = null;

       String query = "select * from book where " + s + ";";

       try {
           stmt = myConnection.createStatement();
           res = stmt.executeQuery(query);

           while (res.next()) {
               Book b = convertToBook(res);
               books.add(b);
           }
       }
       catch(Exception e){
           e.printStackTrace();
           }
        return books;
	}

	public void addBook(Book b){

        Connection myConnection = null;  //address of server
        Statement stmt = null;

        String query = "insert into book values( " + b.getISBN() + "," + b.getTitle() + "," +
                b.getPublisher() + "," + b.getPublication_year() + "," + b.getPrice() + "," +
                b.getCategory() + "," + b.getNo_copies() + "," + b.getThreshold_quantity() + ");";

        try {
            stmt = myConnection.createStatement();
            stmt.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void modifyBook(Book b , String s){

        Connection myConnection = null;  //address of server
        Statement stmt = null;

        String query = "update book set " + s + " where ISBN = " + b.getISBN() + ";" ;
        try {
            stmt = myConnection.createStatement();
            stmt.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void deleteBook(Book b){

        Connection myConnection = null;  //address of server
        Statement stmt = null;

        String query = "delete from book where ISBN =  " + b.getISBN() + ";" ;

        try {
            stmt = myConnection.createStatement();
            stmt.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<User> viewPersonalInfo(String s){
        List<User> users = new ArrayList<>();
        Connection myConnection = null;  //address of server
        Statement stmt = null;
        ResultSet res = null;

        String query = "select * from users where " + s + ";";

        try {
            stmt = myConnection.createStatement();
            res = stmt.executeQuery(query);

            while (res.next()) {
                User u = convertToUser(res);
                users.add(u);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public void editPersonalInfo(User u , String s){
        Connection myConnection = null;  //address of server
        Statement stmt = null;

        String query = "update users set " + s + " where user_name = " + u.getUserName() + ";" ;
        try {
            stmt = myConnection.createStatement();
            stmt.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public List<ShoppingCart> viewShoppingCart(String s){
        List<ShoppingCart> shopping = new ArrayList<>();
        Connection myConnection = null;  //address of server
        Statement stmt = null;
        ResultSet res = null;

        String query = "select ISBN,title,publisher,category,price,quantity " +
                       "from shoppingCart NATURAL JOIN book where " + s + ";";

        try {
            stmt = myConnection.createStatement();
            res = stmt.executeQuery(query);

            while (res.next()) {
                ShoppingCart shop = convertToShoppingCart(res);
                shopping.add(shop);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return shopping;
    }

    public String totalPrice(String s){
        Connection myConnection = null;  //address of server
        Statement stmt = null;
        ResultSet res = null;
        String result = null;

        String query = "select SUM(price) from shoppingCart NATURAL JOIN book where "+ s + ";";

        try {
            stmt = myConnection.createStatement();
            res = stmt.executeQuery(query);
            result = res.getString(0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void removeItemFromCart(ShoppingCart s){
        Connection myConnection = null;  //address of server
        Statement stmt = null;

        String query = "delete from shoppingCart where user_name =  " + s.getUser_name() + " AND ISBN = "
                 + s.getISBN() + ";" ;

        try {
            stmt = myConnection.createStatement();
            stmt.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public void addToShoppingCart(ShoppingCart s){
        Connection myConnection = null;  //address of server
        Statement stmt = null;

        String query = "insert into shoppingCart values( " + s.getUser_name() + "," + s.getISBN() + "," +
               s.getQuantity() + ");";

        try {
            stmt = myConnection.createStatement();
            stmt.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void placeOrder(Order ord){
        Connection myConnection = null;  //address of server
        Statement stmt = null;

        String query = "insert into orders values( " + ord.getUser_name() + "," + ord.getISBN() + "," +
                    ord.getOrder_date() + "," + ord.getQuantity() + "," + ord.getPrice() + ");";

        try {
            stmt = myConnection.createStatement();
            stmt.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public boolean checkCreditCard(String card_no , String expiry_date){
        Connection myConnection = null;  //address of server
        Statement stmt = null;
        ResultSet res = null;
        boolean b = true;

        String query = "select * from creditcard where card_no = " + card_no + "AND expiry_date = "
                        + expiry_date + ";";

        try {
            stmt = myConnection.createStatement();
            res = stmt.executeQuery(query);

            if (res.next()) {
                b = true;
            }
            else {  b = false;  }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }



	public Book convertToBook(ResultSet res){
	   Book b = null;
	    try{
	        b = new Book(res.getString("ISBN"),res.getString("title")
                   ,res.getString("publisher"),res.getString("publication_year"),
                   res.getString("price"),res.getString("category"),
                   res.getString("no_copies"),res.getString("threshold_quantity"));
       }
	   catch (Exception e){
	       e.printStackTrace();
       }
        return b;
    }

    public User convertToUser(ResultSet res){
	    User u = null;
	    try {
	        u = new User(res.getString("user_name"),res.getString("password"),
                    res.getString("first_name"),res.getString("last_name"),
                    res.getString("email"),res.getString("phone_number"),
                    res.getString("shipping_address"),res.getString("privilege"));
        }
	    catch (Exception e){
	        e.printStackTrace();
        }

	    return u;
    }



    public ShoppingCart convertToShoppingCart(ResultSet res){
        ShoppingCart s = null;
        try {
            s = new ShoppingCart(res.getString("user_name"),res.getString("ISBN"),
                    res.getString("quantity"),res.getString("title"),
                    res.getString("publisher"),res.getString("publication_year"),
                    res.getString("price"),res.getString("category"),
                    res.getString("no_copies"),res.getString("threshold_quantity"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return s;
    }
	
}
