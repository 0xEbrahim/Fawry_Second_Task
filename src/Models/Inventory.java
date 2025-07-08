package Models;

import Interfaces.IInventory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public void removeByYear(int year) {
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            Book book = entry.getValue();
            if(LocalDate.now().getYear() - book.getYear() >= year){
                books.remove(entry.getKey());
                bookQuantity.remove(entry.getKey());
            }
        }
    }

    @Override
    public List<Book> getByYear(int year) {
        ArrayList<Book> bookList = new ArrayList<>();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            Book book = entry.getValue();
            if(LocalDate.now().getYear() - book.getYear() >= year){
                bookList.add(book);
            }
        }
        return bookList;
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

    @Override
    public void getBooks() {
        System.out.println("** Books **");
        for(Map.Entry<String, Book> entry : books.entrySet()){
            Book book = entry.getValue();
            int quantity = bookQuantity.get(book.getISBN());
            System.out.println(book.getISBN() + " " + book.getTitle() + " " + quantity);
        }
    }
}
