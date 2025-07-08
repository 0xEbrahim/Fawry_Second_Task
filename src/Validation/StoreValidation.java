package Validation;

public class StoreValidation {
    public static void validateBookQuantity(int currentQuantity, int requiredQuantity){
        if(currentQuantity < requiredQuantity){
            throw new RuntimeException("Store can't provide the required quantity of this book");
        }
    }

}
