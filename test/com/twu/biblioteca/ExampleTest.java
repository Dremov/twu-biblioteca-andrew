package com.twu.biblioteca;


import com.twu.biblioteca.entities.Library;
import com.twu.biblioteca.res.ResStrings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void testWelcome() {
        Library library = new Library(ResStrings.bookNames);
        assertEquals(ResStrings.welcomeMessage, library.welcomeMessage());
    }

    @Test
    public void testBookList() {
        Library library = new Library(ResStrings.bookNames);
        assertEquals(ResStrings.bookNames, library.getBooksTitleList());
    }
}
