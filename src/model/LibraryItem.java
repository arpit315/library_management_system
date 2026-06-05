package model;

import java.time.LocalDateTime;

public abstract class LibraryItem {

    private String id;
    private String title;
    private String genre;
    private LocalDateTime addedAt;

    public LibraryItem(String id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.addedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public abstract void display();
}