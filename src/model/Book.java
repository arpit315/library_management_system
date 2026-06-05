package model;

import interfaces.Borrowable;

public class Book extends LibraryItem implements Borrowable {

    private String author;
    private String isbn;
    private boolean available;

    public Book(String id,
                String title,
                String genre,
                String author,
                String isbn) {

        super(id, title, genre);

        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    // Getters

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    // Borrowable Interface Methods

    @Override
    public void borrow() {
        available = false;
    }

    @Override
    public void returnItem() {
        available = true;
    }

    // Polymorphism

    @Override
    public void display() {

        System.out.println("---------------");
        System.out.println("Book Details");
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Genre: " + getGenre());
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + available);
        System.out.println("---------------");
    }
}