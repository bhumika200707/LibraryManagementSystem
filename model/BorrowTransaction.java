
package model;

import java.time.LocalDate;

public class BorrowTransaction {
    private int transactionId;
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public BorrowTransaction(int transactionId, Book book, Member member) {
        this.transactionId = transactionId;
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(member.getBorrowDays());
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void displayReceipt() {
        System.out.println("\n--- Borrow Receipt ---");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Member: " + member.getName());
        System.out.println("Book: " + book.getTitle());
        System.out.println("Borrow Date: " + borrowDate);
        System.out.println("Due Date: " + dueDate);
    }
}
