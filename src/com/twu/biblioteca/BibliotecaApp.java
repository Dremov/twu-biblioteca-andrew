package com.twu.biblioteca;

import com.twu.biblioteca.entities.Library;
import com.twu.biblioteca.res.ResStrings;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = new Library(ResStrings.booksList, ResStrings.movieList);
        LibraryManager libraryManager = new LibraryManager(library);

        System.out.println(ResStrings.welcomeMessage);

        libraryManager.runMenu(System.in);
//        Printer.printBooksWithTitles(library.getBooksTitleList());  // Story 1.2
//        Printer.printFullBooksInfo(library.getBookList());  // Story 1.3

    }
}
