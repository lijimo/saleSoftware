public class SaleNotExistException extends Exception{
    SaleNotExistException() {
        super("This sale does not exist!");
    }
}
