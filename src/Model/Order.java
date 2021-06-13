package Model;

import java.util.Objects;

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
        this    .price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(user_name, order.user_name) && Objects.equals(ISBN, order.ISBN) && Objects.equals(order_date, order.order_date) && Objects.equals(quantity, order.quantity) && Objects.equals(price, order.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_name, ISBN, order_date, quantity, price);
    }
}
