package com.twu.biblioteca;

import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.entities.Library;
import com.twu.biblioteca.res.ResStrings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryManagerTest {

    private LibraryManager libraryManager;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    private String menuOutput = "\nLibraryManager:\n" +
            "1 - List of books\n" +
            "2 - List of movies\n" +
            "0 - Quit\n";
    private String bookListExtended = "\nAvailable books:\n" +
            "1 - Pride and Prejudice | author1 | year1\n" +
            "2 - The Secret Diary of Adrian Mole | author2 | year2\n" +
            "3 - Catch 22 | author3 | year3\n";

    private String bookList = "\nAvailable books:\n" +
            "1 - Pride and Prejudice\n" +
            "2 - The Secret Diary of Adrian Mole\n" +
            "3 - Catch 22\n";

    private String movieList = "\nAvailable movies:\n" +
            "1|Pulp Fiction - 1994\n" +
            "2|Zombie Shaun - 2007\n";

    private String loginOutput = "Login: \n" +
            "Password: \n";

    private String checkoutInputInfo = ResStrings.bookCheckoutMessage + "\n";
    private String checkoutSuccessful = ResStrings.checkoutBookSuccsessful + "\n";

    @Before
    public void setUp() {
        final Book book1 = new Book("1", "Pride and Prejudice","author1", 2190);
        final Book book2 = new Book("2", "The Secret Diary of Adrian Mole","author2", 1234);
        final Book book3 = new Book("3", "Catch 22","author3", 1290);
        ArrayList<Book> testBooks = new ArrayList<>();
        testBooks.add(book1);
        testBooks.add(book2);
        testBooks.add(book3);


        Library library = new Library(ResStrings.booksList, ResStrings.movieList);

        libraryManager = new LibraryManager(library);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testLoginScreen() {
        String testedOutput = loginOutput;

        libraryManager.run();

        assertEquals(testedOutput, outContent.toString());
    }

    @Test
    public void testCorrectBookListOutput() {
        String testedOutput = bookList + checkoutInputInfo + checkoutSuccessful;

        String inputOption = "1";

        InputStream inputStream = new ByteArrayInputStream(inputOption.getBytes());
        System.setIn(inputStream);

        libraryManager.runBooksMenu(inputStream);

        assertEquals(testedOutput, outContent.toString());
    }

    @Test
    public void testCorrectMoviesOutput() {
        String testedOutput = movieList + checkoutInputInfo + "Pulp Fiction successfully checked out!\n";

        String inputOption = "1";

        InputStream inputStream = new ByteArrayInputStream(inputOption.getBytes());
        System.setIn(inputStream);

        libraryManager.runMoviesMenu(inputStream);

        assertEquals(testedOutput, outContent.toString());
    }
}