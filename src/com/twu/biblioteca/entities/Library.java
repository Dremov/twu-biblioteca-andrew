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

    public Library(String[][] booksList, Map<Integer, String[]> movieList) {
        catalogBooks = new ArrayList<Book>();
        catalogMovies = new ArrayList<Movie>();
        generateBooks(booksList);
        generateMovies(movieList);
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
}
