package model;

import java.time.LocalDateTime;

public class BorrowRecord {

    private Book book;
    private Member member;

    private LocalDateTime borrowedAt;
    private LocalDateTime returnedAt;

    public BorrowRecord(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.borrowedAt = LocalDateTime.now();
        this.returnedAt = null;
    }

    // Getters

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDateTime getBorrowedAt() {
        return borrowedAt;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    // Setter

    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "book=" + book.getTitle() +
                ", member=" + member.getName() +
                ", borrowedAt=" + borrowedAt +
                ", returnedAt=" + returnedAt +
                '}';
    }
}