package com.twu.biblioteca.util;

import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.entities.Movie;
import com.twu.biblioteca.res.ResStrings;

import java.util.List;

public class Printer {

    public static void printBooksWithTitles(List<Book> books) {
        System.out.println(generateBooksTitlesOutput(books));
    }

    public static void printMoviesWithTitles(List<Movie> movies) {
        System.out.println(generateMoviesTitlesOutput(movies));
    }

    public static void printFullBooksInfo(List<Book> books) {
        System.out.println("Available books:");
        for (Book book : books) {
            System.out.println(" - " + book.getTitle() + " | " + book.getAuthor() + " | " + book.getYear());
        }
    }

    public static void printMenu(String[] menuOptions) {
        System.out.println("LibraryManager:");
        for (String option : menuOptions) {
            System.out.println(option);
        }
        System.out.print("Pick an option: ");
    }

    public static String generateBooksTitlesOutput(List<Book> books) {
        StringBuilder sb = new StringBuilder("\nAvailable books:\n");

        for (Book book : books) {
            if (book.isAvailable()) {
                sb.append(book.getId()).append(" - ").append(book.getTitle()).append("\n");
            }
        }
        sb.append(ResStrings.bookCheckoutMessage);

        return sb.toString();
    }

    public static String generateMoviesTitlesOutput(List<Movie> movies) {
        StringBuilder sb = new StringBuilder("\nAvailable movies:\n");

        for (Movie movie : movies) {
            sb.append(movie.getName()).append(" - ").append(movie.getYear()).append("\n");
        }

        sb.append(ResStrings.bookCheckoutMessage);

        return sb.toString();
    }
}

