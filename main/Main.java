
package main;

import java.util.Scanner;

import model.Author;
import model.Book;
import model.Member;
import model.PremiumMember;
import service.Library;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Available Books");
            System.out.println("6. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    library.displayAvailableBooks();
                    break;
                case 6:
                    System.out.println("Thank you for using the library!");
                    break;
                default:
                    System.out.println("Invalid choice! Enter 1 to 6.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input! Please enter a whole number."
                );
            }
        }
    }

    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty. Try again.");
        }
    }

    private static int readPositiveInt(String message) {
        while (true) {
            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println("Enter a number greater than zero.");
        }
    }

    private static void addBook() {
        System.out.println("\n--- Add Book ---");

        int id = readPositiveInt("Enter Book ID: ");
        String title = readText("Enter Book Title: ");
        String authorName = readText("Enter Author Name: ");
        String email = readText("Enter Author Email: ");
        int stock = readPositiveInt("Enter Stock Quantity: ");

        Author author = new Author(authorName, email);
        Book book = new Book(id, title, author, stock);

        library.addBook(book);
    }

    private static void addMember() {
        System.out.println("\n--- Add Member ---");

        int id = readPositiveInt("Enter Member ID: ");
        String name = readText("Enter Member Name: ");

        System.out.println("1. Regular Member");
        System.out.println("2. Premium Member");

        int type;
        do {
            type = readInt("Choose Member Type: ");

            if (type != 1 && type != 2) {
                System.out.println("Please enter 1 or 2.");
            }
        } while (type != 1 && type != 2);

        Member member;

        if (type == 2) {
            member = new PremiumMember(id, name);
        } else {
            member = new Member(id, name);
        }

        library.addMember(member);
    }

    private static void borrowBook() {
        System.out.println("\n--- Borrow Book ---");

        int bookId = readPositiveInt("Enter Book ID: ");
        int memberId = readPositiveInt("Enter Member ID: ");

        library.borrowBook(bookId, memberId);
    }

    private static void returnBook() {
        System.out.println("\n--- Return Book ---");

        int transactionId =
            readPositiveInt("Enter Borrow Transaction ID: ");

        library.returnBook(transactionId);
    }
}
