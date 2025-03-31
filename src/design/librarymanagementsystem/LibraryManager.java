package design.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryManager {
    private static LibraryManager instance;
    private final Map<String, Book> catalog;
    private final Map<String, Member> members;
    private final int MAX_BOOK_PER_MEMBER = 5;
    private final int LOAN_DURATION_DAYS = 14;

    private LibraryManager() {
        this.catalog = new ConcurrentHashMap<>();
        this.members = new ConcurrentHashMap<>();
    }

    public static synchronized LibraryManager getInstance() {
        if (instance == null) {
            instance = new LibraryManager();
        }
        return instance;
    }

    public void addBook(Book b) {
        catalog.put(b.getIsbn(), b);
    }

    public void removeBook(Book b) {
        catalog.remove(b.getIsbn());
    }

    public Book getBook(String isbn) {
        return catalog.get(isbn);
    }

    public void registerMamber(Member m) {
        members.put(m.getMemberId(), m);
    }

    public void unregisterMamber(Member m) {
        members.remove(m.getMemberId());
    }

    public Member getMember(String memberId) {
        return members.get(memberId);
    }

    public synchronized void borrowBook(String memberId, String isbn) {
        Member m = members.get(memberId);
        Book b = catalog.get(isbn);

        if (m != null && b != null && b.isAvailable()) {
            if (m.getBorrowedBooks().size() < MAX_BOOK_PER_MEMBER) {
                m.borrowBook(b);
                b.setAvailable(false);
                System.out.println("Book borrowed:" + b.getTitle() + " by " + m.getName());

            } else {
                System.out.println(m.getName() + "reached max capacity of borrowing books");
            }
        } else {
            System.out.println("Book or member not found or book not available right now");
        }
    }

    public synchronized void returnBook(String memberId, String isbn) {
        Member m = members.get(memberId);
        Book b = catalog.get(isbn);
        if (m != null && b != null) {
            m.returnBook(b);
            b.setAvailable(true);
            System.out.println("Book returned" + b.getTitle() + " By " + m.getName());
        } else {
            System.out.println("Book or member not found");
        }
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book b : catalog.values()) {
            if (b.getTitle().contains(keyword) || b.getAuthor().contains(keyword)) {
                matchingBooks.add(b);
            }
        }
        return matchingBooks;
    }

}
