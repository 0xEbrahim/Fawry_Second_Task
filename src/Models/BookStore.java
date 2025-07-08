package Models;

import Services.EmailService;
import Services.PaymentService;
import Services.ShippingService;
import Validation.StoreValidation;

import java.util.List;
import java.util.Map;

public class BookStore {
    private Inventory inventory;

    BookStore(Inventory inventory) {
        this.inventory = inventory;
    }

    void addBook(Book book) {
    }

    void getBooks() {
    }

    void removeBook(String ISBN) {
    }

    void removeOutdatedBooks(int year) {
    }

    List<Book> getOutdatedBooks() {
        return null;
    }

    void buyBook(String ISBN, int quantity, String email, String address) {
        Map<String, Book> books = inventory.getBooksInventory();
        Map<String, Integer> bookQuantity = inventory.getBookQuantity();
        if (books.containsKey(ISBN)) {
            Book book = books.get(ISBN);
            StoreValidation.validateBookQuantity(bookQuantity.get(ISBN), quantity);
            if (book instanceof EBook) {
                PaymentService.buyBook(book, quantity);
                EmailService.sendEmail(book, email);
            } else if (book instanceof PaperBook) {
                PaymentService.buyBook(book, quantity);
                ShippingService.shippingBook(book, quantity, address);
            } else if (book instanceof DemoBook) {
                throw new RuntimeException("Demo books are not for sale.");
            }
        } else {
            throw new RuntimeException("Book Not Found");
        }
    }


}
