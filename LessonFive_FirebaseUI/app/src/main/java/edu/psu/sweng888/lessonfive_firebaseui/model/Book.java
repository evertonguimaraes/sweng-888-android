package edu.psu.sweng888.lessonfive_firebaseui.model;

import java.io.Serializable;

public class Book implements Serializable {

    private String author;
    private Long isbn;
    private String publication;
    private String publisher;
    private String title;

    public Book() {
    }

    public Book(String author, Long isbn, String publication, String publisher, String title) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publication = publication;
        this.isbn = isbn;
    }

    /** Getters and Setters */
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}
