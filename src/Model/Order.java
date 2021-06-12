package Model;

public class Order {

    private String user_name;
    private String ISBN;
    private String order_date;
    private String quantity;
    private String price;

    public Order(String user_name, String ISBN, String order_date, String quantity, String price) {
        this.user_name = user_name;
        this.ISBN = ISBN;
        this.order_date = order_date;
        this.quantity = quantity;
        this.price = price;
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

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
