package Models;

import Interfaces.IInventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory implements IInventory {
    Map<String, Book> books;
    Map<String, Integer>bookQuantity;
    Inventory(){
        books = new HashMap<>();
        bookQuantity = new HashMap<>();
    }

    @Override
    public void add(Book book) {
        books.put(book.getISBN(), book);
        bookQuantity.put(book.getTitle(), bookQuantity.get(book.getTitle()) + 1);
    }

    @Override
    public void removeByYears(int years) {

    }

    @Override
    public void getByYear(int year) {

    }

    @Override
    public void removeByISBN(String ISBN) {
        if(books.containsKey(ISBN)){
            books.remove(ISBN);
        }else{
            throw new RuntimeException("Book not found");
        }
    }

    @Override
   public Book getByISBN(String ISBN) {
        Book book;
        if(books.containsKey(ISBN)){
            book = books.get(ISBN);
        }else{
            throw new RuntimeException("Book not found");
        }
        return book;
    }
}
