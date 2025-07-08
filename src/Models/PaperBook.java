package Models;

import Interfaces.Shippable;

public class PaperBook extends Book implements Shippable {
    private int stocks;

    public PaperBook(String title, String ISBN, String author, int year, double price, int stocks) {
        super(title, ISBN, author, year, price);
        this.stocks = stocks;
    }

    public int getStocks() {
        return stocks;
    }

    @Override
    public void reduceStocks(int quantity) {
        if (stocks < quantity) {
            throw new RuntimeException("We don't have enough stocks for this book");
        }
        this.stocks -=  quantity;
    }
}
