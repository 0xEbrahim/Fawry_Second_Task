import Test.StoreTest;


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