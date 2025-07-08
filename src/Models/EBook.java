package Models;

public class EBook extends Book {
    private String fileType;

    public EBook(String title, String ISBN,String author, int year, double price,String fileType) {
        super(title, ISBN,author, year, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }
}
