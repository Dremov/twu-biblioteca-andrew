package com.twu.biblioteca.entities;

import com.twu.biblioteca.res.ResStrings;
import com.twu.biblioteca.util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Library {

    private ArrayList<Book> catalogBooks;
    private ArrayList<Movie> catalogMovies;
    private ArrayList<User> userList;

    public Library(String[][] booksList, Map<Integer, String[]> movieList, String[][] userList) {
        this.catalogBooks = new ArrayList<Book>();
        this.catalogMovies = new ArrayList<Movie>();
        this.userList = new ArrayList<User>();
        generateBooks(booksList);
        generateMovies(movieList);
        generateUsers(userList);
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Book> getCatalogBooks() {
        return catalogBooks;
    }

    public void setCatalogBooks(ArrayList<Book> catalogBooks) {
        this.catalogBooks = catalogBooks;
    }

    public ArrayList<Movie> getCatalogMovies() {
        return catalogMovies;
    }

    public void setCatalogMovies(ArrayList<Movie> catalogMovies) {
        this.catalogMovies = catalogMovies;
    }

    public String welcomeMessage() {
        return ResStrings.welcomeMessage;
    }

    public String[] getBooksTitleList() {
        List<String> booksTitles = new ArrayList<String>();

        for (Book book : catalogBooks) {
            booksTitles.add(book.getTitle());
        }

        return booksTitles.toArray(new String[0]);
    }

    private void generateBooks(String[][] bookList) {
        for (String[] book : bookList) {
            this.catalogBooks.add(new Book(book[0], book[1], book[2], Integer.parseInt(book[3])));
        }
    }

    private void generateMovies(Map<Integer, String[]> movieList) {
        for (Map.Entry<Integer, String[]> entry : movieList.entrySet()) {
            this.catalogMovies.add(new Movie(
                    entry.getKey(),
                    entry.getValue()[0],                        // name
                    Integer.parseInt(entry.getValue()[1]),      // year
                    entry.getValue()[2],                        // director
                    Integer.parseInt(entry.getValue()[3])));    // rating
        }
    }

    private void generateUsers(String[][] userList) {
        for (String[] user : userList) {
            ArrayList<Book> holdedBooks = new ArrayList<>();
            try {
                holdedBooks.add(new Book("", user[2], "", 0));
            } catch (Exception e) {
//                this.userList.add(new User(user[0], user[1], holdedBooks));
            }
            this.userList.add(new User(user[0], user[1], holdedBooks));


        }

    }
}
