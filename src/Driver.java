

import Model.Book;

import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;

public class Driver {


	
	public Statement signIn(String userName, String password) {
		Connection myConnection;
		Statement myStatement = null;
		try {
			// get a connection to database.
			myConnection = DriverManager.getConnection("");
			myStatement = myConnection.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return myStatement;
	}

//	public Statement signUp() {
		

//	}

	public List<Book> searchBook(String s){
       List<Book> books = new ArrayList<>();
       Connection myConnection = null;  //address of server
	    Statement stmt = null;
       ResultSet res = null;

       String query = "select * from book where" + s + ";";

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

        String query = "update book set " + s + "where ISBN = " + b.getISBN() + ";" ;
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
	
}
