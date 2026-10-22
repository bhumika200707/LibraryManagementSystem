
package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReturnTransaction {
    private BorrowTransaction borrowTransaction;
    private LocalDate returnDate;
    private long lateDays;
    private double fine;

    public ReturnTransaction(BorrowTransaction borrowTransaction) {
        this.borrowTransaction = borrowTransaction;
        this.returnDate = LocalDate.now();

        this.lateDays = ChronoUnit.DAYS.between(
            borrowTransaction.getDueDate(), returnDate
        );

        if (lateDays > 0) {
            this.fine = lateDays * 5.0;
        } else {
            this.fine = 0.0;
        }
    }

    public double getFine() {
        return fine;
    }

    public void displayReceipt() {
        System.out.println("\n--- Return Receipt ---");
        System.out.println("Book: " +
            borrowTransaction.getBook().getTitle());
        System.out.println("Member: " +
            borrowTransaction.getMember().getName());
        System.out.println("Return Date: " + returnDate);
        System.out.println("Late Days: " + Math.max(0, lateDays));
        System.out.println("Fine: Rs. " + fine);
    }
}
