package com.twu.biblioteca;

import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.entities.Library;
import com.twu.biblioteca.res.ResStrings;
import com.twu.biblioteca.util.Printer;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class ExampleTest {

    @Test
    public void testWelcome() {
        Library library = new Library(ResStrings.booksList, ResStrings.movieList);
        assertEquals(ResStrings.welcomeMessage, library.welcomeMessage());
    }

    @Test
    public void testBooksGenerated() {
        Library library = new Library(ResStrings.booksList, ResStrings.movieList);
        assertFalse(library.getCatalogBooks().isEmpty());
    }

    @Test
    public void testMoviesGenerated() {
        Library library = new Library(ResStrings.booksList, ResStrings.movieList);
        assertFalse(library.getCatalogMovies().isEmpty());
    }

    @Test
    public void testBookTitleListOutput() {
        String[][] books = ResStrings.booksList;
        Library library = new Library(books, ResStrings.movieList);

        assertEquals("\nAvailable books:\n" +
                books[0][0]+" - "+books[0][1]+"\n" +
                books[1][0]+" - "+books[1][1]+"\n" +
                books[2][0]+" - "+books[2][1]+"\n" +
                ResStrings.bookCheckoutMessage, Printer.generateBooksTitlesOutput(library.getCatalogBooks()));
    }

    @Test
    public void testBookCheckout() {
//        Library libraryMock = mock(Library.class);
        Library library = new Library(ResStrings.booksList, ResStrings.movieList);
        Book bookMock = mock(Book.class);

        LibraryManager libraryManager = new LibraryManager(library);

        String inputOption = "2";

        InputStream inputStream = new ByteArrayInputStream(inputOption.getBytes());
        System.setIn(inputStream);

        libraryManager.runBooksMenu(inputStream);
        verify(bookMock, atLeastOnce()).setAvailable(false);
    }

//    @Test
//    public void testMenuCallsBookCatalog() {
//        Library libraryMock = mock(Library.class);
//        Library library = new Library(ResStrings.booksList, ResStrings.movieList);
//
//        LibraryManager libraryMenuMock = mock(LibraryManager.class);
//        LibraryManager libraryMenu = new LibraryManager(library);
//
//        String inputOption = "1";
//
//        InputStream inputStream = new ByteArrayInputStream(inputOption.getBytes());
//        System.setIn(inputStream);
//
//        libraryMenu.runMenu(inputStream);
//        verify(libraryMenu, times(1)).runBooksMenu(inputStream);
//    }
//
//    @Test
//    public void testMenuCallsMovieCatalog() {
//        Library library = new Library(ResStrings.booksList);
//        LibraryManager libraryMenu = new LibraryManager(library);
//
//        String inputOption = "2";
//
//        InputStream inputStream = new ByteArrayInputStream(inputOption.getBytes());
//        System.setIn(inputStream);
//
//        libraryMenu.runMenu(inputStream);
//
//        verify(libraryMenu, times(1)).runMoviesMenu();

//    }

}
