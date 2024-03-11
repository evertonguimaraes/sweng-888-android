package edu.psu.sweng888.lessonfive_fragmentsui.data;

import java.io.Serializable;

import edu.psu.sweng888.lessonfive_fragmentsui.R;

public class Book implements Serializable {

    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private int imageResourceId;

    public Book() {
    }

    public Book(String title, String author, String isbn, String publisher) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getImageResourceId() {
        return R.drawable.ic_book;
    }
}
