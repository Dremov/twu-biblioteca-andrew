package com.twu.biblioteca.res;

import java.util.HashMap;
import java.util.Map;

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
            "2 - List of movies",
            "0 - Quit"
    };

    public static String[][] booksList = {
            {"1", "Pride and Prejudice", "Jane Austen", "1813"},
            {"2", "The Secret Diary of Adrian Mole", "Sue Townsend", "1982"},
            {"3", "Catch 22", "Joseph Heller", "1961"}
    };

    public static Map<Integer, String[]> movieList = createMap();

    private static Map<Integer, String[]> createMap() {
        Map<Integer,String[]> myMap = new HashMap<Integer, String[]>();
        myMap.put(1, new String[]{"Pulp Fiction", "1994", "Tarantino", "10"});
        myMap.put(2, new String[]{"Zombie Shaun", "2007", "Director", "10"});
        return myMap;
    }

    public static String[][] userList = {
            {"123-1234", "1234", "Book dummy"},
            {"4321-321", "4321"}
    };

}
