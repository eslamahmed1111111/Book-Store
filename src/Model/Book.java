package Model;

public class Book {
    private String ISBN;
    private String title;
    private String publisher,author;
    private String publicationYear;
    private int price;
    private String category;
    private int numOfCopies;

    public Book(String title, String publisher, String author, String publicationYear, int price, String category, int numOfCopies){
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
        this.numOfCopies = numOfCopies;
    }



}
