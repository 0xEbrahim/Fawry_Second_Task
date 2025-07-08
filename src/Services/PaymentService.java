package Services;

import Models.Book;

public class PaymentService {
    public static void buyBook(Book book, int quantity){
        double totalPrice = book.getPrice() * quantity;
        System.out.println(totalPrice + "$ is paid successfully");
    }
}
