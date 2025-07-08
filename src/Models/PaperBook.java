package Models;

public class PaperBook extends  Book{
    private int stocks;

    public PaperBook(String title, String ISBN, int year, int price,int pages, int stocks) {
        super(title, ISBN, year, price, pages);
        this.stocks = stocks;
    }
}
