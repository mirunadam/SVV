package ro.upt;

public class InvalidBookPagesException extends RuntimeException {
    public InvalidBookPagesException(String message) {
        super(message);
    }
}
