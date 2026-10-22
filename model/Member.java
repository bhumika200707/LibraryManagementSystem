
package model;

public class Member {
    private int memberId;
    private String name;
    private int maxBooks;
    private int borrowDays;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.maxBooks = 3;
        this.borrowDays = 14;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getMaxBooks() {
        return maxBooks;
    }

    public int getBorrowDays() {
        return borrowDays;
    }

    public void displayMember() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Maximum Books: " + maxBooks);
        System.out.println("Borrowing Period: " + borrowDays + " days");
    }
}
