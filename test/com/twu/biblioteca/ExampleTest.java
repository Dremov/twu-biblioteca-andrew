package com.twu.biblioteca;


import com.twu.biblioteca.res.ResStrings;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void testWelcome() {
        Library library = new Library();
        assertEquals(ResStrings.welcomeMessage, library.welcomeMessage());
    }
}
