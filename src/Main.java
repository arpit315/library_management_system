import catalog.SearchResult;
import exceptions.BookNotAvailableException;
import model.Book;
import model.Member;
import service.LibraryService;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();

        // =========================
        // Add Books
        // =========================

        service.addBook(
                new Book(
                        "101",
                        "Java Programming",
                        "Programming",
                        "Om Singh",
                        "ISBN101"
                )
        );

        service.addBook(
                new Book(
                        "102",
                        "cpp Programming",
                        "Programming",
                        "Anjali",
                        "ISBN102"
                )
        );

        service.addBook(
                new Book(
                        "103",
                        "Design Patterns",
                        "Programming",
                        "Rahul Kumar",
                        "ISBN103"
                )
        );

        service.addBook(
                new Book(
                        "104",
                        "Sanskrit",
                        "Core Subjects",
                        "Arnab",
                        "ISBN104"
                )
        );

        service.addBook(
                new Book(
                        "105",
                        "Spring Boot",
                        "Technology",
                        "Suraj Kumar",
                        "ISBN105"
                )
        );

        service.addBook(
                new Book(
                        "106",
                        "Advanced Java",
                        "Programming",
                        "James Bond",
                        "ISBN106"
                )
        );

        // =========================
        // Add Members
        // =========================

        service.addMember(
                new Member(
                        "101",
                        "Arpit Kumar",
                        "arpit@gmail.com"
                )
        );

        service.addMember(
                new Member(
                        "102",
                        "Rahul Sharma",
                        "rahul@gmail.com"
                )
        );

        service.addMember(
                new Member(
                        "103",
                        "Rishu Singh",
                        "Rishu@gmail.com"
                )
        );

        // =========================
        // Search By Author
        // =========================

        System.out.println("\n===== SEARCH BY AUTHOR =====");

        SearchResult<Book> searchResult =
                service.searchByAuthor("Om Singh");

        for (Book book : searchResult.getResults()) {
            book.display();
        }

        // =========================
        // Available Books
        // =========================

        System.out.println("\n===== AVAILABLE BOOKS =====");

        List<Book> availableBooks =
                service.getAvailableBooks();

        for (Book book : availableBooks) {
            System.out.println(book.getTitle());
        }

        // =========================
        // Sort By Title
        // =========================

        System.out.println("\n===== SORTED BOOKS =====");

        List<Book> sortedBooks =
                service.getSortedByTitle();

        for (Book book : sortedBooks) {
            System.out.println(book.getTitle());
        }

        // =========================
        // Borrow Book
        // =========================

        System.out.println("\n===== BORROW BOOK =====");

        try {

            service.borrowBook(
                    "101",
                    "101"
            );

            // Borrow Same Book Again

            service.borrowBook(
                    "102",
                    "101"
            );

        } catch (BookNotAvailableException e) {

            System.out.println(
                    "Exception: "
                            + e.getMessage()
            );
        }

        // =========================
        // Return Book
        // =========================

        System.out.println("\n===== RETURN BOOK =====");

        service.returnBook(
                "101",
                "101"
        );

        // =========================
        // Borrow Again
        // =========================

        System.out.println("\n===== BORROW AGAIN =====");

        try {

            service.borrowBook(
                    "102",
                    "101"
            );

        } catch (BookNotAvailableException e) {

            System.out.println(
                    e.getMessage()
            );
        }

        // =========================
        // Group By Genre
        // =========================

        System.out.println("\n===== GROUP BY GENRE =====");

        Map<String, List<Book>> groupedBooks =
                service.groupByGenre();

        groupedBooks.forEach((genre, books) -> {

            System.out.println(
                    "\nGenre : " + genre
            );

            books.forEach(
                    book -> System.out.println(
                            "- " + book.getTitle()
                    )
            );
        });
    }
}