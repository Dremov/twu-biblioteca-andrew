package com.twu.biblioteca;

import com.twu.biblioteca.entities.Library;
import com.twu.biblioteca.res.ResStrings;
import com.twu.biblioteca.util.Printer;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = new Library(ResStrings.booksList);

        System.out.println(ResStrings.welcomeMessage);

        library.runMenu();
//        Printer.printBooksWithTitles(library.getBooksTitleList());  // 1.2
//        Printer.printFullBooksInfo(library.getBookList());  // 1.3

    }
}
