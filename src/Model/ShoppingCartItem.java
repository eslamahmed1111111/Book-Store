package Model;


import java.util.Objects;

public class ShoppingCartItem{

    private Book book;
    private  String user_name;
    private  String ISBN;
    private  String quantity;

    public ShoppingCartItem(String user_name, String ISBN, String quantity,String title, String publisher,
                        String author , String publication_year, String price, String category, String no_copies,
                        String threshold_quantity) {
        book = new Book(ISBN, title , publisher , author , publication_year , price , category , no_copies , threshold_quantity);
        this.user_name = user_name;
        this.ISBN = ISBN;
        this.quantity = quantity;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartItem that = (ShoppingCartItem) o;
        return Objects.equals(book, that.book) && Objects.equals(user_name, that.user_name) && Objects.equals(ISBN, that.ISBN) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, user_name, ISBN, quantity);
    }
}
