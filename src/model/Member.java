package model;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String memberId;
    private String name;
    private String email;

    private List<BorrowRecord> borrowHistory;

    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowHistory = new ArrayList<>();
    }

    // Getters

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<BorrowRecord> getBorrowHistory() {
        return borrowHistory;
    }

    // Add borrowing record

    public void addBorrowRecord(BorrowRecord record) {
        borrowHistory.add(record);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}