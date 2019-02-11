package com.twu.biblioteca.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private Movie movie;
    private String title = "title";
    private String director = "author";
    private int year = 1234;
    private int rating = 9;

    @Before
    public void setup() {
        movie = new Movie(1, title, year, director, rating);
    }

    @Test
    public void getName() {
        assertEquals(title, movie.getName());
    }

    @Test
    public void getYear() {
        assertEquals(year, movie.getYear());
    }

    @Test
    public void getDirector() {
        assertEquals(director, movie.getDirector());
    }

    @Test
    public void getRating() {
        assertEquals(rating, movie.getRating());

        Movie movie2 = new Movie(2, title, year, director, 12);
        assertEquals(10, movie2.getRating());

        Movie movie3 = new Movie(3, title, year, director, -2);
        assertEquals(1, movie3.getRating());
    }
}