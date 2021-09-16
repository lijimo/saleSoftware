public class NotPublishedException extends Exception{
    NotPublishedException() {
        super("This item is not published!");
    }
}
