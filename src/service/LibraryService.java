package service;

import catalog.LibraryCatalog;
import catalog.SearchResult;
import exceptions.BookNotAvailableException;
import exceptions.BookNotFoundException;
import exceptions.MemberNotFoundException;
import model.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {

    private LibraryCatalog<Book> catalog;
    private Map<String, Member> members;
    private Set<String> genres;
    private Queue<BorrowRequest> requests;

    public LibraryService() {
        catalog = new LibraryCatalog<>();
        members = new HashMap<>();
        genres = new HashSet<>();
        requests = new LinkedList<>();
    }

    // Add Book

    public void addBook(Book book) {
        catalog.add(book);
        genres.add(book.getGenre());
    }

    // Add Member

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    // Search By Author

    public SearchResult<Book> searchByAuthor(String author) {

        List<Book> result = catalog.getItems()
                .stream()
                .filter(book ->
                        book.getAuthor()
                                .equalsIgnoreCase(author))
                .toList();

        return new SearchResult<>(result, author);
    }

    // Available Books

    public List<Book> getAvailableBooks() {

        return catalog.getItems()
                .stream()
                .filter(Book::isAvailable)
                .toList();
    }

    // Sorted Books

    public List<Book> getSortedByTitle() {

        return catalog.getItems()
                .stream()
                .sorted(
                        Comparator.comparing(Book::getTitle)
                )
                .toList();
    }

    // Borrow Book

    public void borrowBook(String memberId,
                           String bookId)
            throws BookNotAvailableException {

        Member member = members.get(memberId);

        if (member == null) {
            throw new MemberNotFoundException(
                    "Member not found : " + memberId);
        }

        Book book = catalog.findById(bookId);

        if (book == null) {
            throw new BookNotFoundException(
                    "Book not found : " + bookId);
        }

        if (!book.isAvailable()) {

            requests.offer(
                    new BorrowRequest(member, book)
            );

            throw new BookNotAvailableException(
                    "Book already borrowed. Request added to queue."
            );
        }

        book.borrow();

        BorrowRecord record =
                new BorrowRecord(book, member);

        member.addBorrowRecord(record);

        System.out.println(
                member.getName() +
                        " borrowed " +
                        book.getTitle()
        );
    }

    // Return Book

    public void returnBook(String memberId,
                           String bookId) {

        Member member = members.get(memberId);

        if (member == null) {
            throw new MemberNotFoundException(
                    "Member not found : " + memberId);
        }

        Book book = catalog.findById(bookId);

        if (book == null) {
            throw new BookNotFoundException(
                    "Book not found : " + bookId);
        }

        for (BorrowRecord record :
                member.getBorrowHistory()) {

            if (record.getBook().getId().equals(bookId)
                    && record.getReturnedAt() == null) {

                record.setReturnedAt(
                        LocalDateTime.now());

                book.returnItem();

                System.out.println(
                        member.getName()
                                + " returned "
                                + book.getTitle());

                break;
            }
        }

        processQueue();
    }

    // Group By Genre

    public Map<String, List<Book>> groupByGenre() {

        return catalog.getItems()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Book::getGenre
                        )
                );
    }

    // Process Waiting Queue

    private void processQueue() {

        if (!requests.isEmpty()) {

            BorrowRequest request =
                    requests.poll();

            System.out.println(
                    "Processing queued request : "
                            + request
            );
        }
    }

    // Getter

    public Set<String> getGenres() {
        return genres;
    }
}