package com.twu.biblioteca.entities;

import java.util.ArrayList;

public class User {
    private String id;
    private String pass;
    private ArrayList<Book> booksCheckedout;

    public User(String id, String pass, ArrayList<Book> booksCheckedout) {
        this.id = id;
        this.pass = pass;
        this.booksCheckedout = booksCheckedout;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<Book> getBooksCheckedout() {
        return booksCheckedout;
    }

    public void setBooksCheckedout(ArrayList<Book> booksCheckedout) {
        this.booksCheckedout = booksCheckedout;
    }

    public void addBookToCart(Book book) {
        this.booksCheckedout.add(book);
    }
}
