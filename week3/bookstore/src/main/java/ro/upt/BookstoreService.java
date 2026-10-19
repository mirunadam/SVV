package ro.upt;

/**
 * This is the test class.
 */
public class BookstoreService {
    public double calculateBookPrice(Book book, BookstoreSubscription subscription) {
        if (book == null || subscription == null){
            throw new InvalidBookstoreParametersException("Book and subscription cannot be null");
        }
        if (book.getTitle()==null || book.getTitle().isEmpty()) {
            throw new InvalidBookTitleException("Book title is empty");
        }

        if (book.getNoPages() <= 0){
            throw new InvalidBookPagesException("Invalid book number of pages");
        }

        double totalPrice = book.getNoPages() * 0.25;

        if (subscription.equals(BookstoreSubscription.SUBSCRIPTION)) {
            totalPrice /= 2;
        }

        return totalPrice;
    }
}
