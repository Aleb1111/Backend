package back.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Book {

    @Id
    private String id;

    private String bookTitle;
    private String author;
    private int noOfPages;

    // Constructors, Getters, and Setters
    public Book() {
    }
    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
    public Book(String title, String author, int numberOfPages) {
        this.id = generateUniqueId();
        this.bookTitle = title;
        this.author = author;
        this.noOfPages = numberOfPages;
    }

    // Getters and Setters
    // Id field doesn't need a setter, as it's generated
    public String  getId() {
        return id;
    }

    public void setBookTitle(String title) {
        this.bookTitle = title;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setID(){
        this.id = generateUniqueId();
    }
    public void setNoOfPages(int numberOfPages) {
        this.noOfPages = numberOfPages;
    }

    public int getNoOfPages() {
        return noOfPages;
    }
}
