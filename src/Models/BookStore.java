package Models;

import Interfaces.Shippable;
import Services.EmailService;
import Services.PaymentService;
import Services.ShippingService;
import Validation.StoreValidation;

import java.util.List;
import java.util.Map;

public class BookStore {
    private final Inventory inventory;

    public BookStore(Inventory inventory) {
        this.inventory = inventory;
    }
    public Book getByISBN(String ISBN){
        StoreValidation.checkBookExist(ISBN, this);
        return this.inventory.getByISBN(ISBN);
    }
   public void addBook(Book book) {
        this.inventory.add(book);
    }

    public void getBooks() {
        this.inventory.getBooks();
    }

    public  void removeBook(String ISBN) {
        this.inventory.removeByISBN(ISBN);
    }

    public List<Book> removeOutdatedBooks(int year) {
        return this.inventory.removeByYear(year);
    }

    public List<Book> getOutdatedBooks(int year) {
        return this.inventory.getByYear(year);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void buyBook(String ISBN, int quantity, String email, String address) {
        Map<String, Book> books = inventory.getBooksInventory();
        StoreValidation.checkBookExist(ISBN, this);
        Book book = books.get(ISBN);
        if (book instanceof EBook) {
            PaymentService.buyBook(book, quantity);
            EmailService.sendEmail(book, email);
        } else if (book instanceof Shippable) {
            StoreValidation.validateBookQuantity(((Shippable) book).getStocks(), quantity);
            PaymentService.buyBook(book, quantity);
            ShippingService.shippingBook(book, quantity, address);
            ((Shippable) book).reduceStocks(quantity);
        } else if (book instanceof DemoBook) {
            throw new RuntimeException("Demo books are not for sale.");
        }
    }


}
