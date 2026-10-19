package ro.upt;

/**
 * Thrown inside BookstoreService when the given title is invalid.
 */
public class InvalidBookTitleException extends RuntimeException {
    public InvalidBookTitleException(String msg){ super(msg);}
}
