package com.twu.biblioteca.entities;

public class Book {

    private String title;
    private String author;
    private int year;

    public Book(String bookTitle, String author, int year) {
        setTitle(bookTitle);
        setAuthor(author);
        setYear(year);
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
