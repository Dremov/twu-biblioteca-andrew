package com.twu.biblioteca.entities;

import com.twu.biblioteca.res.ResStrings;
import com.twu.biblioteca.util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private ArrayList<Book> catalogBooks;

    public Library(String[][] booksList) {
        catalogBooks = new ArrayList<Book>();
        generateBooks(booksList);
    }

    public String welcomeMessage() {
        return ResStrings.welcomeMessage;
    }

    public ArrayList<Book> getBookList() {
        return catalogBooks;
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
        Printer.printBooksWithTitles(catalogBooks);

        boolean control = true;
        boolean bookExists = false;

        while (control) {
            Scanner input = new Scanner(System.in);
            String choiceInput = input.next();

            for (Book book : catalogBooks) {
                if (choiceInput.equals(book.getId())) {
                    bookExists = true;
                    if (book.isAvailable()) {
                        book.setAvailable(false);
                        System.out.println(ResStrings.checkoutBookSuccsessful);
                        control = false;
                    } else {
//                        System.out.println(ResStrings.checkoutBookUnseccsessful);
//                        Printer.printBooksWithTitles(catalogBooks);
                        book.setAvailable(true);
//                        System.out.println(ResStrings.checkoutBookSuccsessful);
                        control = false;
                    }
                }
            }
            if (!bookExists) {
                System.out.println(ResStrings.checkoutBookUnseccsessful);
                Printer.printBooksWithTitles(catalogBooks);
            }
        }
    }
}
