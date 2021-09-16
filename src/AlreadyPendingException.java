public class AlreadyPendingException extends Exception {
    AlreadyPendingException() {
        super("This item is already pending!");
    }
}
