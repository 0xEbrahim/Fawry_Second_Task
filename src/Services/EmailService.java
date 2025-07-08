package Services;

import Models.Book;

public class EmailService {
    public static void sendEmail(Book ebook, String email) {
        System.out.println("Book sent to: " + email);
    }
}
