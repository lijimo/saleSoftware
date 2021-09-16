public class NotPendingException extends Exception{

    NotPendingException() {
        super("This item is not pending and therefore cannot be published!");
    }
}
