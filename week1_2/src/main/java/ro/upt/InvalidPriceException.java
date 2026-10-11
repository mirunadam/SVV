package ro.upt;

public class InvalidPriceException extends RuntimeException{
    public InvalidPriceException(String msg){
        super(msg);
    }
}
