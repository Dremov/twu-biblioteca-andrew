package com.twu.biblioteca.entities;

public class Book {

    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String id, String bookTitle, String author, int year) {
        setId(id);
        setTitle(bookTitle);
        setAuthor(author);
        setYear(year);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }
}
