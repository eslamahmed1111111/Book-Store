package Model;

public class Book {
    private String ISBN;
    private String title;
    private String publisher;
    private String publication_year;
    private String price;
    private String category;
    private String no_copies;
    private String threshold_quantity;

    public Book(String ISBN, String title, String publisher, String publication_year,
                String price, String category, String no_copies, String threshold_quantity) {
        this.ISBN = ISBN;
        this.title = title;
        this.publisher = publisher;
        this.publication_year = publication_year;
        this.price = price;
        this.category = category;
        this.no_copies = no_copies;
        this.threshold_quantity = threshold_quantity;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNo_copies() {
        return no_copies;
    }

    public void setNo_copies(String no_copies) {
        this.no_copies = no_copies;
    }

    public String getThreshold_quantity() {
        return threshold_quantity;
    }

    public void setThreshold_quantity(String threshold_quantity) {
        this.threshold_quantity = threshold_quantity;
    }


}
