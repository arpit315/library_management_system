package model;

public class Magazine extends LibraryItem {

    private int issueNumber;
    private String publisher;

    public Magazine(String id,
                    String title,
                    String genre,
                    int issueNumber,
                    String publisher) {

        super(id, title, genre);

        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    // Getters

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    // Setters

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public void display() {

        System.out.println("---------------");
        System.out.println("Magazine Details");
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Genre: " + getGenre());
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Publisher: " + publisher);
        System.out.println("---------------");
    }
}