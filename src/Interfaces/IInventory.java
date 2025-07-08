package Interfaces;

import Models.Book;

import java.util.List;

public interface IInventory {
    void add(Book book);
    void removeByYear(int years);
    List<Book> getByYear(int year);
    void removeByISBN(String ISBN);
    Book getByISBN(String ISBN);
}
