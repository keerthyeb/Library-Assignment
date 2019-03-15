package com.step.classroom;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private boolean hasBorrowed;
    private List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        hasBorrowed = false;
        borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isHasBorrowed() {
        return hasBorrowed;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setHasBorrowed(boolean hasBorrowed) {
        this.hasBorrowed = hasBorrowed;
    }

    public void addBorrowedBook(Book book){
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book){ borrowedBooks.remove(book);}


}
