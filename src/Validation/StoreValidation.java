package Validation;

import Models.BookStore;

public class StoreValidation {

    public static void validateBookQuantity(int currentQuantity, int requiredQuantity){
        if(currentQuantity < requiredQuantity){
            throw new RuntimeException("Store can't provide the required quantity of this book");
        }
    }

    public static void checkBookExist(String ISBN, BookStore bookStore){
        if(!bookStore.getInventory().getBooksInventory().containsKey(ISBN)){
            throw new  RuntimeException("Book with ISBN "+ISBN+" does not exist");
        }
    }
}
