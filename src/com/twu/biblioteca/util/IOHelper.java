package com.twu.biblioteca.util;

import java.io.InputStream;
import java.util.Scanner;

public class IOHelper {

    public String readline(InputStream inputStream) {

        while (true) {
            Scanner input = new Scanner(inputStream);
            String inputString = input.next();

            return inputString;
        }
    }
}
