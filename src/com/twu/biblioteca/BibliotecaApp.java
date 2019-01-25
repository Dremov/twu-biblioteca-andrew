package com.twu.biblioteca;

import com.twu.biblioteca.entities.Library;
import com.twu.biblioteca.res.ResStrings;
import com.twu.biblioteca.util.Printer;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = new Library(ResStrings.bookNames);

        Printer.printMessage(ResStrings.welcomeMessage);
        Printer.printBooksTitles(library.getBooksTitleList());

    }
}
