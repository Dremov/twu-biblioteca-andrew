package com.twu.biblioteca.entities;

import com.twu.biblioteca.res.ResStrings;
import com.twu.biblioteca.util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private ArrayList<Book> availableBooks;

    public Library(String[][] booksList) {
        availableBooks = new ArrayList<Book>();
        generateBooks(booksList);
    }

    public String welcomeMessage() {
        return ResStrings.welcomeMessage;
    }

    public ArrayList<Book> getBookList() {
        return availableBooks;
    }

    public String[] getBooksTitleList() {
        List<String> booksTitles = new ArrayList<String>();

        for (Book book : availableBooks) {
            booksTitles.add(book.getTitle());
        }

        return booksTitles.toArray(new String[0]);
    }

    private void generateBooks(String[][] bookList) {
        for (String[] book : bookList) {
            this.availableBooks.add(new Book(book[0], book[1], book[2], Integer.parseInt(book[3])));
        }
    }

    public void runMenu() {
        boolean control = true;
        Printer.printMenu(ResStrings.menuOptions);

        while (control) {
            Scanner input = new Scanner(System.in);
            String choiceInput = input.next();

            try {
                int choice = Integer.parseInt(choiceInput);
                switch (choice) {
                    case 1:
                        Printer.printBooksWithTitles(availableBooks);
                        runBooksMenu();
                        break;

                    case 0:
                        System.exit(0);
                        break;

                    default:
                        System.out.println(ResStrings.invalidMenuOption);
                        break;
                }

                Printer.printMenu(ResStrings.menuOptions);

            } catch (NumberFormatException e) {
                System.out.println(ResStrings.invalidMenuOption);
            }
        }
    }

    private void runBooksMenu() {
        boolean control = true;

        while (control) {
            Scanner input = new Scanner(System.in);
            String choiceInput = input.next();
        }
    }

}
