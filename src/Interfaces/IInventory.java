package Interfaces;

import Models.Book;

public interface IInventory {
    void add(Book book);
    void removeByYears(int years);
    void getByYear(int year);
    void removeByISBN(String ISBN);
    Book getByISBN(String ISBN);
}
