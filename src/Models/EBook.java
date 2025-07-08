package Models;

public class EBook extends Book {
    private String fileType;

    public EBook(String title, String ISBN, int year, int price,int pages, String fileType) {
        super(title, ISBN, year, price, pages);
        this.fileType = fileType;
    }
}
