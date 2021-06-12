package Model;

public class ShoppingCart extends Book{

    private  String user_name;
    private  String ISBN;
    private  String quantity;


    public ShoppingCart(String user_name , String ISBN , String quantity){

        this.user_name = user_name;
        this.ISBN = ISBN;
        this.quantity = quantity;
    }

    public ShoppingCart(String user_name, String ISBN, String quantity,String title, String publisher,
                        String author , String publication_year, String price, String category, String no_copies,
                        String threshold_quantity) {
        super(ISBN, title , publisher , author , publication_year , price , category , no_copies , threshold_quantity);
        this.user_name = user_name;
        this.ISBN = ISBN;
        this.quantity = quantity;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
