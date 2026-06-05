package model;

import java.time.LocalDateTime;

public class BorrowRequest {

    private Member member;
    private Book book;
    private LocalDateTime requestedAt;

    public BorrowRequest(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.requestedAt = LocalDateTime.now();
    }

    // Getters

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    @Override
    public String toString() {
        return "BorrowRequest{" +
                "member=" + member.getName() +
                ", book=" + book.getTitle() +
                ", requestedAt=" + requestedAt +
                '}';
    }
}