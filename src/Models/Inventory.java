package Models;

import Interfaces.IInventory;
import Interfaces.Shippable;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory implements IInventory {
    Map<String, Book> books;
    public Inventory(){
        books = new HashMap<>();
    }

    @Override
    public void add(Book book) {
        books.put(book.getISBN(), book);
        System.out.println(book.getTitle() + " added to the inventory");
    }

    @Override
    public List<Book> removeByYear(int year) {
        ArrayList<Book> bookList = (ArrayList<Book>) this.getByYear(year);
        for(Book book : bookList){
            books.remove(book.getISBN());
        }
        return bookList;
    }

    @Override
    public List<Book> getByYear(int year) {
        ArrayList<Book> bookList = new ArrayList<>();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            Book book = entry.getValue();
            if(Year.now().getValue()- book.getYear() >= year){
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
            if(book instanceof Shippable){
                System.out.println(((Shippable) book).getStocks() + "X "+book.getISBN() + " " + book.getTitle() );
            }else{
                System.out.println(book.getISBN() + " " + book.getTitle());
            }
        }
    }

    public Map<String, Book> getBooksInventory() {
        return books;
    }

}
