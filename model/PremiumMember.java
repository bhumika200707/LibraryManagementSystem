
package model;

public class PremiumMember extends Member {

    public PremiumMember(int memberId, String name) {
        super(memberId, name);
    }

    @Override
    public int getMaxBooks() {
        return 5;
    }

    @Override
    public int getBorrowDays() {
        return 30;
    }

    @Override
    public void displayMember() {
        System.out.println("Premium Member ID: " + getMemberId());
        System.out.println("Name: " + getName());
        System.out.println("Maximum Books: " + getMaxBooks());
        System.out.println("Borrowing Period: " + getBorrowDays() + " days");
    }
}
