package Model;

public class Book {
    private String ISBN;
    private String title;
    private String publisher, author;
    private String publicationYear;
    private String price;
    private String category;
    private String numOfCopies;
    private String thresholdQuantity;

    public Book(String ISBN, String title, String publisher, String author, String publicationYear, String price, String category, String numOfCopies, String thresholdQuantity) {
        this.ISBN = ISBN;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
        this.numOfCopies = numOfCopies;
        this.thresholdQuantity = thresholdQuantity;
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

    public String getPublicationYear() {
        return publicationYear;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumOfCopies() {
        return numOfCopies;
    }

    public void setNumOfCopies(String numOfCopies) {
        this.numOfCopies = numOfCopies;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThresholdQuantity() {
        return thresholdQuantity;
    }

    public void setThresholdQuantity(String thresholdQuantity) {
        this.thresholdQuantity = thresholdQuantity;
    }
}


