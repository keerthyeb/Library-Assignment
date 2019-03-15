package com.step.classroom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("AtmaLibrary");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to library.");
        while (true) {
            System.out.println("Enter Choice.");
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

                default:
                    System.out.println("Quitting Library");
                    System.exit(0);
            }
        }
    }
}
