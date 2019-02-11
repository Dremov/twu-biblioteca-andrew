package com.twu.biblioteca;

import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.entities.Library;
import com.twu.biblioteca.res.ResStrings;
import com.twu.biblioteca.util.Printer;

import java.io.InputStream;
import java.util.Scanner;

public class LibraryManager {

    private Library library;

    public LibraryManager(Library library) {
        this.library = library;
    }

    public void runMenu(InputStream inputStream) {
        boolean control = true;
        Printer.printMenu(ResStrings.menuOptions);

        while (control) {
            Scanner input = new Scanner(inputStream);
            String choiceInput = input.next();

            execMenuOption(choiceInput);

        }
    }

    public void execMenuOption(String inputOption) {
        try {
            int choice = Integer.parseInt(inputOption);
            switch (choice) {
                case 1:
                    runBooksMenu(System.in);
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

    public void runBooksMenu(InputStream inputStream) {
        Printer.printBooksWithTitles(library.getCatalogBooks());

        boolean control = true;
        boolean bookExists = false;

        while (control) {
            Scanner input = new Scanner(inputStream);
            String choiceInput = input.next();

            for (Book book : library.getCatalogBooks()) {
                if (choiceInput.equals(book.getId())) {
                    bookExists = true;
                    if (book.isAvailable()) {
                        book.setAvailable(false);
                        System.out.println(ResStrings.checkoutBookSuccsessful);
                        return;
                    } else {
                        book.setAvailable(true);
                        System.out.println(ResStrings.returnBookSuccessful);
                        return;
                    }
                }
            }
            if (!bookExists) {
                System.out.println(ResStrings.invalidCatalogAction);
                Printer.printBooksWithTitles(library.getCatalogBooks());
            }
        }
    }

    public void runMoviesMenu(InputStream inputStream) {
        Printer.printMoviesWithTitles(library.getCatalogMovies());
    }
}
