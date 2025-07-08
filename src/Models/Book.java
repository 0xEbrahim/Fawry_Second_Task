package Models;

public abstract class Book {
    private String title, ISBN, author;
    private int year, pages;
    private double price;

    public Book(String title, String ISBN, String author, int year, double price) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.year = year;
        this.price = price;
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
