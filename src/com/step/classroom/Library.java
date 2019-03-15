package com.step.classroom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private String librarian;
    private List<Book> books;
    private List<Book> avaliableBooks;
    private Map<Book, User> borrowedBookDetails;
    private Map<User, ArrayList<Book>> usersDetails;

    public Library(String librarian) {
        this.librarian = librarian;
        books = new ArrayList<>();
        avaliableBooks = new ArrayList<>();
        usersDetails = new HashMap<>();
        borrowedBookDetails = new HashMap<>();
    }

    public boolean addUser(String name) {
        User user = getUser(name);
        if (!(user == null)) {
            return false;
        }
        User currentUser = new User(name);
        usersDetails.put(currentUser, new ArrayList<Book>());
        return true;
    }

    public User getUser(String userName) {
        for (User user : usersDetails.keySet()) {
            if (user.getName().equals(userName)) return user;
        }
        return null;
    }


    public boolean addBook(String bookName) {
        Book newBook = new Book(bookName);
        books.add(newBook);
        avaliableBooks.add(newBook);
        return true;
    }

    public boolean isBookPresent(String bookName) {
        if (getBook(bookName) == null) return false;
        return true;
    }

    public boolean borrowBook(String readerName, String bookName) {
        Book book = getBook(bookName);
        User currentUser = getUser(readerName);
        if (book == null || currentUser == null) {
            return false;
        }
        currentUser.addBorrowedBook(book);
        avaliableBooks.remove(book);
        borrowedBookDetails.put(book, currentUser);
        usersDetails.get(currentUser).add(book);
        return true;
    }

    public Book getBook(String bookName) {
        for (Book book : avaliableBooks) {
            if (book.getName().equals(bookName)) return book;
        }
        return null;
    }

    public Book getBookFromAllBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) return book;
        }
        return null;
    }

    public boolean isBorrowed(String userName, String bookName) {
        User user = getUser(userName);
        Book book = getBookFromAllBook(bookName);
        if (user == null || book == null) return false;
        return this.usersDetails.get(user).contains(book);
    }

    public boolean returnBooks(String userName, String bookName) {
        if (!isBorrowed(userName, bookName)) return false;
        try {
            Book book = getBookFromAllBook(bookName);
            User user = getUser(userName);
            avaliableBooks.add(book);
            borrowedBookDetails.remove(book);
            usersDetails.get(user).remove(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String whoHasBorrowed(String bookName) {
        Book book = getBookFromAllBook(bookName);
        try {
            return borrowedBookDetails.get(book).getName();
        } catch (Exception e) {
            return "No one borrowed";
        }
    }

    public ArrayList borrowedBooksByUser(String username) {
        User user = getUser(username);
        return usersDetails.get(user);
    }

    @Override
    public String toString() {
        return "Library{" +
                "librarian='" + librarian + '\n' +
                ", books=" + books +
                ", \navaliableBooks=" + avaliableBooks +
                ", \nborrowedBookDetails=" + borrowedBookDetails +
                ", \nusersDetails=" + usersDetails +
                '}';
    }


    public boolean removeBook(String bookName) {
        try {
            if(!books.contains(bookName)) return false;
            books.remove(getBook(bookName));
            avaliableBooks.remove(getBook(bookName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isRemoved(String bookName) {
        try {
            return !books.contains(getBook(bookName));
        } catch (Exception e) {
            return false;
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getAvaliableBooks() {
        return avaliableBooks;
    }
}
