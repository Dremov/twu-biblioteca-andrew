package com.twu.biblioteca.res;

public class ResStrings {
    public static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    public static String invalidMenuOption = "Please select a valid option!\n";
    public static String bookCheckoutMessage = "\nTo check-out or return a book, please type its id: ";
    public static String checkoutBookSuccsessful = "Thank you! Enjoy the book\n";
    public static String checkoutBookUnseccsessful = "Sorry, that book is not available\n";
    public static String checkoutBookUnseccsessful2 = "Sorry, that book id doesn't exist\n";
    public static String returnBookSuccessful = "Thank you for returninghe book\n";
    public static String invalidCatalogAction = "Sorry, that book is not available or that is not a valid book to return\n";


    public static String[] menuOptions = {
            "1 - List of books",
            "0 - Quit"
    };

    public static String[][] booksList = {
            {"1", "Pride and Prejudice", "Jane Austen", "1813"},
            {"2", "The Secret Diary of Adrian Mole", "Sue Townsend", "1982"},
            {"3", "Catch 22", "Joseph Heller", "1961"}
    };
}
