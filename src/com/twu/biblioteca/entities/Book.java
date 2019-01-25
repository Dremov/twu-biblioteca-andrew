package com.twu.biblioteca.entities;

public class Book {

    private String title;

    public Book(String bookTitle) {
        setTitle(bookTitle);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
