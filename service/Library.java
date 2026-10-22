
package service;

import java.util.ArrayList;
import java.util.List;

import model.Author;
import model.Book;
import model.Member;
import model.BorrowTransaction;
import model.ReturnTransaction;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<BorrowTransaction> activeTransactions = new ArrayList<>();

    private int nextTransactionId = 1;

    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getBookId() == book.getBookId()) {
                System.out.println("Error: Book ID already exists.");
                return;
            }
        }

        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void addMember(Member member) {
        for (Member m : members) {
            if (m.getMemberId() == member.getMemberId()) {
                System.out.println("Error: Member ID already exists.");
                return;
            }
        }

        members.add(member);
        System.out.println("Member registered successfully!");
    }

    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        boolean found = false;

        for (Book book : books) {
            if (book.getStock() > 0) {
                book.displayBook();
                System.out.println("--------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books are currently available.");
        }
    }

    public BorrowTransaction borrowBook(int bookId, int memberId) {
        Book selectedBook = null;
        Member selectedMember = null;

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                selectedBook = book;
                break;
            }
        }

        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                selectedMember = member;
                break;
            }
        }

        if (selectedBook == null) {
            System.out.println("Error: Book not found.");
            return null;
        }

        if (selectedMember == null) {
            System.out.println("Error: Member not found.");
            return null;
        }

        if (selectedBook.getStock() <= 0) {
            System.out.println("Error: Book is out of stock.");
            return null;
        }

        int borrowedCount = 0;

        for (BorrowTransaction transaction : activeTransactions) {
            if (transaction.getMember().getMemberId() == memberId) {
                borrowedCount++;
            }
        }

        if (borrowedCount >= selectedMember.getMaxBooks()) {
            System.out.println("Error: Borrowing limit reached.");
            return null;
        }

        BorrowTransaction transaction = new BorrowTransaction(
            nextTransactionId++, selectedBook, selectedMember
        );

        selectedBook.setStock(selectedBook.getStock() - 1);
        activeTransactions.add(transaction);

        System.out.println("Book borrowed successfully!");
        transaction.displayReceipt();

        return transaction;
    }

    public ReturnTransaction returnBook(int transactionId) {
        BorrowTransaction borrowed = null;

        for (BorrowTransaction transaction : activeTransactions) {
            if (transaction.getTransactionId() == transactionId) {
                borrowed = transaction;
                break;
            }
        }

        if (borrowed == null) {
            System.out.println("Error: Active borrowing transaction not found.");
            return null;
        }

        ReturnTransaction returnTransaction =
            new ReturnTransaction(borrowed);

        borrowed.getBook().setStock(
            borrowed.getBook().getStock() + 1
        );

        activeTransactions.remove(borrowed);

        returnTransaction.displayReceipt();
        System.out.println("Book returned successfully!");

        return returnTransaction;
    }
}
