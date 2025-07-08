# Fawry_Second_Task

## About
This is an online book store, which sells multi-types of books and has support to show you a demo copy of the book but you can't buy it. <br>


## Features
- Book store has an inventory:
  - You can add books to the inventory
  - you can remove outdated books from inventory
  - choose a book from the inventory to buy
    - Provide shipping for books which require shipping like paper books
    - Provide email service to send e-books
- Including validation to check if the current in-stock quantity of the book will be enough lfor the order.
- handling purchasing by controling the number of stocks remaining
- Added testing functions covers almost all the features and it works.


## ScreenShots

- These are the samples which i used over all tests, You can find the testing file on `Test` Folder.
  ```java
  PaperBook paperBook1 = BookFactory.createPaperBook("III123", "Hello book", "Mahmoud", 1999, 22.5, 15);
    PaperBook paperBook2 = BookFactory.createPaperBook("III124", "Hello World", "Khalid", 1995, 22.5, 10);
    EBook ebook1 = BookFactory.createEBook("III147", "English made easy", "Ibrahim", 2000, 21.1, "pdf");
    DemoBook demo = BookFactory.createDemoBook("III1244", "Demo book", "Salah", 2010);

  ```
- And this is the main function:
  ```java
  public class Main {
    public static void main(String[] args) {
        StoreTest test = new StoreTest();
        test.AddBookTest();
        test.buyBookTest();
        test.removeBookTest();
        test.removeOutDatedTest();
        test.notEnoughStocksTest();
        test.bookNotExistsTest();
    }
}
  ```
1 - Testing add functionality
  - Code:
```java
    public void AddBookTest() {
        BookStore bookStore = new BookStore(new Inventory());
        bookStore.addBook(paperBook1);
        bookStore.getBooks();
        bookStore.addBook(paperBook2);
        bookStore.addBook(ebook1);
        bookStore.getBooks();
        bookStore.addBook(demo);
        bookStore.getBooks();
    }
```
  - Output:
    ![image](https://github.com/user-attachments/assets/0b16713f-e829-497a-a643-fc028ea9b0de)

2 - Testing Buying functionality
  - Code:
```java
  public void buyBookTest() {
        BookStore bookStore = new BookStore(new Inventory());
        bookStore.addBook(paperBook1);
        bookStore.addBook(paperBook2);
        bookStore.addBook(ebook1);
        bookStore.addBook(demo);
        bookStore.buyBook(ebook1.getISBN(), 2, "ebrahim@email.com", "Cairo");
        bookStore.buyBook(paperBook1.getISBN(), 1, "ebrahim@gmail.com", "Giza");
    }
```
  - Output: ![image](https://github.com/user-attachments/assets/26ee253e-8d14-4291-942b-6e690ec5eda7)

3 - Testing remove book functionality
  - Code:
```java
public void removeBookTest() {
        BookStore bookStore = new BookStore(new Inventory());
        PaperBook paperBook1 = BookFactory.createPaperBook("III123", "Hello book", "Mahmoud", 1999, 22.5, 15);
        bookStore.addBook(paperBook1);
        bookStore.getBooks();
        bookStore.removeBook(paperBook1.getISBN());
        bookStore.getBooks();
    }
```
  - Output: ![image](https://github.com/user-attachments/assets/9b6c949e-6d26-417d-bbea-86c61ead5256)

4 - Test remove and return outdated functionality
  - Code:
```java
 public void removeOutDatedTest() {
        BookStore bookStore = new BookStore(new Inventory());
        bookStore.addBook(paperBook1);
        bookStore.addBook(paperBook2);
        bookStore.addBook(ebook1);
        bookStore.addBook(demo);
        List<Book> removed = bookStore.removeOutdatedBooks(10);
        for (Book book : removed) {
            System.out.println(book.getTitle());
        }
    }
```
  - Output: ![image](https://github.com/user-attachments/assets/ad204684-77df-4266-b917-e49e9e2aaa77)

5 - Test not enough stocks remaining functionality
  - Code:
```java
 public void notEnoughStocksTest() {
        BookStore bookStore = new BookStore(new Inventory());
        bookStore.addBook(paperBook1);
        bookStore.buyBook(paperBook1.getISBN(), 10000, "email@gmail.com", "cairo");
    }
```
  - Output: ![image](https://github.com/user-attachments/assets/471dbbc8-557f-4e98-a148-f13d6395ed0c)

6 - Test existance of a book
  - Code:
```java
public void bookNotExistsTest() {
        BookStore bookStore = new BookStore(new Inventory());
        bookStore.getByISBN("III111");
    }
```
  - Output: ![image](https://github.com/user-attachments/assets/5b63ee86-a4a4-4c19-87f9-c9a7a9417d22)




