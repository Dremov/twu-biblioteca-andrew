package com.twu.biblioteca;

import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.entities.Library;
import com.twu.biblioteca.entities.Movie;
import com.twu.biblioteca.entities.User;
import com.twu.biblioteca.res.ResStrings;
import com.twu.biblioteca.util.Printer;

import java.io.InputStream;
import java.util.Scanner;

public class LibraryManager {

    private Library library;

    public LibraryManager(Library library) {
        this.library = library;
    }

    public void run() {
        System.out.println(getHoldedBooks());

        System.out.println("Login: \n" +
                "Password: ");
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

                case 2:
                    runMoviesMenu(System.in);
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

        while (true) {
            Scanner input = new Scanner(inputStream);
            String choiceInput = input.next();

            for (Movie movie : library.getCatalogMovies()) {
                if (Integer.parseInt(choiceInput) == movie.getId()) {
                    System.out.println(movie.getName() + " successfully checked out!");
                    return;
                }
            }
        }
    }

    public boolean userExists(String id, String pass) {
        for (User user : library.getUserList()) {
            if (user.getId().equals(id) && user.getPass().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public String getHoldedBooks() {
        StringBuilder sb = new StringBuilder("Books to be returned:\n");

        for (User user : library.getUserList()) {
            if (!user.getBooksCheckedout().isEmpty()) {
                sb.append(user.getId()).append(" - '").append(user.getBooksCheckedout().get(0).getTitle()).append("'\n");
            }
        }
        return sb.toString();
    }
}
