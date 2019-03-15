package com.step.classroom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library library;
    String BOOK_NAME = "C++";
    Book letUsC;
    String USER_NAME = "Keerthy";

    @BeforeEach
    void setUp() {
        library = new Library("AtmaLibrary");
        library.addUser(USER_NAME);
        library.addUser("Amju");
        library.addBook(BOOK_NAME);
        library.addBook("C");
        letUsC = new Book(BOOK_NAME);
        library.borrowBook("Amju","C");

    }

    @Test
    void it_should_add_a_new_user() {
        assertTrue(library.addUser("Moothu"));
    }

    @Test
    void it_should_addBook() {
        assertTrue(library.getBooks().containsKey(BOOK_NAME));
    }

    @Test
    void it_should_return_if_isBookPresent() {
        assertTrue(library.isBookPresent(BOOK_NAME));
    }

    @Test
    void borrowBook() {
        assertTrue(library.borrowBook(USER_NAME,BOOK_NAME));
    }

    @Test
    void isBorrowed() {
        library.borrowBook("Amju","C++");
        assertTrue(library.isBorrowed("Amju","C++"));
    }

    @Test
    void returnBooks() {
        library.returnBooks("Keerthy","C++");
        assertTrue(library.getAvaliableBooks().contains(new Book("C++")));
    }

    @Test
    void whoHasBorrowed() {
        assertEquals(library.whoHasBorrowed("C"),"Amju");
    }

    @Test
    void borrowedBooksByUser() {
        ArrayList<Book> borrowedBooks = library.borrowedBooksByUser("Amju");
        ArrayList<Book> expectedOutput = new ArrayList<>();
        expectedOutput.add(new Book("C"));
        assertEquals(borrowedBooks,expectedOutput);
    }

    @Test
    void removeBook() {
        library.removeBook("C");
        assertFalse(library.getBooks().containsKey("C"));
    }

    @Test
    void isRemoved() {
        library.removeBook("C");
        assertTrue(library.isRemoved("C"));

    }
}