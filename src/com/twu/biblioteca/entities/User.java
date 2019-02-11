package com.twu.biblioteca.entities;

import java.util.ArrayList;

public class User {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String pass;
    private ArrayList<Book> booksCheckedout;

    public User(String id, String pass, ArrayList<Book> booksCheckedout) {
        this.id = id;
        this.pass = pass;
        this.booksCheckedout = booksCheckedout;
    }

    public User(String id, String pass, String name, String email, String phone, ArrayList<Book> booksCheckedout) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.booksCheckedout = booksCheckedout;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
