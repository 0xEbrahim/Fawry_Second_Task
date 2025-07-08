package Models;

public abstract class Book {
    private String title, ISBN;
    private int year, pages;
    private double price;
    public int getPages() {
        return pages;
    }

    public Book(String title, String ISBN, int year, double price, int pages) {
        this.title = title;
        this.ISBN = ISBN;
        this.year = year;
        this.price = price;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
}
