package com.step.classroom;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("AtmaLibrary");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to library.");
        while (true) {
            System.out.println("\nEnter Choice.\n" +
                    "1: Add user\n" +
                    "2: Add book\n" +
                    "3: Show library\n" +
                    "4: search book\n" +
                    "5: Borrow book\n" +
                    "6: Isborrowed\n" +
                    "7: Return books\n" +
                    "8: Who borrowed which book\n" +
                    "9: Books borrowed by a perticular user\n" +
                    "10: Remove book\n" +
                    "11: Check is removed or not\n" +
                    "12: Quit\n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Reader Name to insert");
                    String readerName = scanner.nextLine();
                    boolean wasSuccessfull = library.addUser(readerName);
                    System.out.println(wasSuccessfull ? "Added Successfully" : "Already Exist");
                    break;

                case 2:
                    System.out.println("Book Name to insert");
                    String bookname = scanner.nextLine();
                    wasSuccessfull = library.addBook(bookname);
                    System.out.println(wasSuccessfull ? "Added Successfully" : "Already Exist");
                    break;

                case 3:
                    System.out.println("Showing Library details");
                    System.out.println(library);
                    break;

                case 4:
                    System.out.println("Enter the book to search");
                    String bookName = scanner.nextLine();
                    wasSuccessfull = library.isBookPresent(bookName);
                    System.out.println(wasSuccessfull ? "book present" : "book not present");
                    break;

                case 5:
                    System.out.println("enetr the username ");
                    readerName = scanner.nextLine();
                    System.out.println("Enter the book to borrow");
                    bookName = scanner.nextLine();
                    wasSuccessfull = library.borrowBook(readerName, bookName);
                    System.out.println(wasSuccessfull ? "borrowed successfully" : "borrow failed");
                    break;

                case 6:
                    System.out.println("enetr the username ");
                    readerName = scanner.nextLine();
                    System.out.println("Enter the book to know it is borrowed");
                    bookName = scanner.nextLine();
                    wasSuccessfull = library.isBorrowed(readerName, bookName);
                    System.out.println(wasSuccessfull ? readerName + "has borrowed " + bookName : readerName + "has not borrowed " + bookName);
                    break;

                case 7:
                    System.out.println("enetr the username ");
                    readerName = scanner.nextLine();
                    System.out.println("Enter the book to return");
                    bookName = scanner.nextLine();
                    wasSuccessfull = library.returnBooks(readerName, bookName);
                    System.out.println(wasSuccessfull ? "returned successfully" : "return failed");
                    break;

                case 8:
                    System.out.println("Enter the book name");
                    bookName = scanner.nextLine();
                    readerName = library.whoHasBorrowed(bookName);
                    System.out.println(readerName);
                    break;

                case 9:
                    System.out.println("enetr the username ");
                    readerName = scanner.nextLine();
                    ArrayList<Book> borrowedbooks = library.borrowedBooksByUser(readerName);
                    System.out.println(borrowedbooks);
                    break;

                case 10:
                    System.out.println("Enter the book name to remove");
                    bookName = scanner.nextLine();
                    wasSuccessfull = library.removeBook(bookName);
                    System.out.println(wasSuccessfull ? bookName + " removed successfully " : "not removed ");
                    break;

                case 11:
                    System.out.println("Enter the book name to check if it is removed or not");
                    bookName = scanner.nextLine();
                    wasSuccessfull = library.isRemoved(bookName);
                    System.out.println(wasSuccessfull ? "it is removed" : "it is not removed");
                    break;

                case 12:
                    System.out.println("Quitting Library");
                    System.exit(0);
            }
        }
    }
}
