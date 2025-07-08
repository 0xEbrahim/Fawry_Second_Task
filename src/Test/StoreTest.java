package Test;

import Factory.BookFactory;
import Models.*;

import java.util.List;

public class StoreTest {

    PaperBook paperBook1 = BookFactory.createPaperBook("III123", "Hello book", "Mahmoud", 1999, 22.5, 15);
    PaperBook paperBook2 = BookFactory.createPaperBook("III124", "Hello World", "Khalid", 1995, 22.5, 10);
    EBook ebook1 = BookFactory.createEBook("III147", "English made easy", "Ibrahim", 2000, 21.1, "pdf");
    DemoBook demo = BookFactory.createDemoBook("III1244", "Demo book", "Salah", 2010);

    public void AddBookTest() {
        BookStore bookStore = new BookStore(new Inventory());
        bookStore.addBook(paperBook1);
        bookStore.getBooks();
        bookStore.addBook(paperBook2);
        bookStore.addBook(ebook1);
        bookStore.getBooks();
        bookStore.addBook(demo);
        bookStore.getBooks();
    }

    public void removeBookTest() {
        BookStore bookStore = new BookStore(new Inventory());
        PaperBook paperBook1 = BookFactory.createPaperBook("III123", "Hello book", "Mahmoud", 1999, 22.5, 15);
        bookStore.addBook(paperBook1);
        bookStore.getBooks();
        bookStore.removeBook(paperBook1.getISBN());
        bookStore.getBooks();
    }

    public void removeOutDatedTest() {
        BookStore bookStore = new BookStore(new Inventory());
        bookStore.addBook(paperBook1);
        bookStore.addBook(paperBook2);
        bookStore.addBook(ebook1);
        bookStore.addBook(demo);
        List<Book> removed = bookStore.removeOutdatedBooks(10);

        System.out.println(" ** removed Books from Store **");
        for (Book book : removed) {
            System.out.println(book.getTitle());
        }
    }

    public void buyBookTest() {
        BookStore bookStore = new BookStore(new Inventory());
        bookStore.addBook(paperBook1);
        bookStore.addBook(paperBook2);
        bookStore.addBook(ebook1);
        bookStore.addBook(demo);
        bookStore.buyBook(ebook1.getISBN(), 2, "ebrahim@email.com", "Cairo");
        bookStore.buyBook(paperBook1.getISBN(), 1, "ebrahim@gmail.com", "Giza");
    }

    public void notEnoughStocksTest() {
        BookStore bookStore = new BookStore(new Inventory());
        bookStore.addBook(paperBook1);
        bookStore.buyBook(paperBook1.getISBN(), 10000, "email@gmail.com", "cairo");
    }

    public void bookNotExistsTest() {
        BookStore bookStore = new BookStore(new Inventory());
        bookStore.getByISBN("III111");
    }
}
