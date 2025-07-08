package Factory;

import Models.Book;
import Models.DemoBook;
import Models.EBook;
import Models.PaperBook;

public class BookFactory {
    public static EBook createEBook(String ISBN, String title, String author, int year, double price, String fileType) {
        return new EBook(title, ISBN, author,year, price, fileType);
    }

    public static PaperBook createPaperBook(String ISBN, String title, String author, int year, double price, int stocks) {
        return new PaperBook(title, ISBN, author, year, price, stocks);
    }
    public static DemoBook createDemoBook(String ISBN, String title, String author, int year) {
        return new DemoBook(title, ISBN, author, year);
    }
}
