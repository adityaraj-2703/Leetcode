package design.librarymanagementsystem;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        LibraryManager lm = LibraryManager.getInstance();
        lm.addBook(new Book("ISBN1", "Book 1", "Author 1", 2020));
        lm.addBook(new Book("ISBN2", "Book 2", "Author 2", 2021));
        lm.addBook(new Book("ISBN3", "Book 3", "Author 3", 2022));

        lm.registerMamber(new Member("Member1", "Aditya Raj", "adi@gmail.com"));
        lm.registerMamber(new Member("Member2", "Sunny", "sunny@gmail.com"));

        lm.borrowBook("Member1", "ISBN1");
        lm.borrowBook("Member2", "ISBN2");
        lm.returnBook("Member1", "ISBN1");

        List<Book> search = lm.searchBooks("Author 2");
        for (Book b : search) {
            System.out.println(b.getTitle() + " by " + b.getAuthor());
        }

    }

}
