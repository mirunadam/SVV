package ro.upt;

public class InvalidBookstoreParametersException extends RuntimeException {
    public InvalidBookstoreParametersException(String message) {
        super(message);
    }
}
