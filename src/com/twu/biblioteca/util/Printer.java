package com.twu.biblioteca.util;

import com.twu.biblioteca.entities.Book;

import java.util.List;

public class Printer {

    public static void printMessage(String message) {
        System.out.println(message + "\n");
    }

    public static void printBooksWithTitles(String[] titles) {
//        System.out.println("Available books:");
//        for(String title : titles) {
//            System.out.println(" - " + title);
//        }
        System.out.println(generateBooksTitlesOutput(titles));
    }

    public static void printFullBooksInfo(List<Book> books) {
        System.out.println("Available books:");
        for(Book book : books) {
            System.out.println(" - " + book.getTitle() + " | " + book.getAuthor() + " | " + book.getYear());
        }
    }

    public static String generateBooksTitlesOutput(String[] titles) {
        StringBuilder sb = new StringBuilder("Available books:\n");

        for(String title : titles) {
            sb.append(" - ").append(title).append("\n");
        }

        return sb.toString();
    }
}
