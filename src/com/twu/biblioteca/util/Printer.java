package com.twu.biblioteca.util;

public class Printer {

    public static void printMessage(String message) {
        System.out.println(message + "\n");
    }

    public static void printBooksTitles(String[] titles) {
        System.out.println("Available books:");
        for(String title : titles) {
            System.out.println(" - " + title);
        }
    }
}
