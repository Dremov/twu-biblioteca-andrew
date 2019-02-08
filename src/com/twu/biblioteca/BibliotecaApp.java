package com.twu.biblioteca;

import com.twu.biblioteca.entities.Library;
import com.twu.biblioteca.res.ResStrings;
import com.twu.biblioteca.util.Printer;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = new Library(ResStrings.booksList, ResStrings.movieList);
        LibraryMenu libraryMenu = new LibraryMenu(library);

        System.out.println(ResStrings.welcomeMessage);

        libraryMenu.runMenu(System.in);
//        Printer.printBooksWithTitles(library.getBooksTitleList());  // Story 1.2
//        Printer.printFullBooksInfo(library.getBookList());  // Story 1.3

    }
}
