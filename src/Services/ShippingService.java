package Services;

import Models.Book;

public class ShippingService {
    public static void shippingBook(Book book, int quantity, String address) {
        System.out.println("** Shipping Book **");
        System.out.println(quantity + "X " + book.getTitle());
        System.out.println("Shipped to " + address);
    }
}
