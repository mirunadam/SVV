package ro.upt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookstoreServiceTest {
    private BookstoreService bookstoreService;
    @BeforeEach
    public void setUp() {
        bookstoreService = new BookstoreService();
    }

    @Test
    public void testNoSubscription() {
        double result = bookstoreService.calculateBookPrice(new Book("Poezii", "Eminescu", 300), BookstoreSubscription.NO_SUBSCRIPTION);
        Assertions.assertEquals(75, result);
    }

    @Test
    public void testSubscription() {
        double result = bookstoreService.calculateBookPrice(new Book("Poezii", "Eminescu", 300), BookstoreSubscription.SUBSCRIPTION);
        Assertions.assertEquals(37.5, result);
    }

    @Test
    public void testNullBook() {
        InvalidBookstoreParametersException invalidBookstoreParametersException = Assertions.assertThrows(
                InvalidBookstoreParametersException.class,
                () -> bookstoreService.calculateBookPrice(null, BookstoreSubscription.NO_SUBSCRIPTION));
        Assertions.assertEquals("Book and subscription cannot be null", invalidBookstoreParametersException.getMessage());
    }

    @Test
    public void testNullSubscription() {
        InvalidBookstoreParametersException invalidBookstoreParametersException = Assertions.assertThrows(
                InvalidBookstoreParametersException.class,
                () -> bookstoreService.calculateBookPrice(new Book("da", "da", 30), null));
        Assertions.assertEquals("Book and subscription cannot be null", invalidBookstoreParametersException.getMessage());
    }

    @Test
    public void testNullTitle() {
        InvalidBookTitleException invalidBookTitleException = Assertions.assertThrows(
                InvalidBookTitleException.class,
                () -> bookstoreService.calculateBookPrice(new Book(null, "Eminescu",300), BookstoreSubscription.SUBSCRIPTION)
        );

        Assertions.assertEquals("Book title is empty", invalidBookTitleException.getMessage());
    }

    @Test
    public void testNoPages(){
        InvalidBookPagesException invalidBookPagesException = Assertions.assertThrows(
                InvalidBookPagesException.class,
                () -> bookstoreService.calculateBookPrice(new Book("Poezii", "Eminescu",-3), BookstoreSubscription.SUBSCRIPTION)
        );

        Assertions.assertEquals("Invalid book number of pages", invalidBookPagesException.getMessage());
    }

    @Test
    public void testNoTitle(){
        InvalidBookTitleException invalidBookTitleException = Assertions.assertThrows(
                InvalidBookTitleException.class,
                () -> bookstoreService.calculateBookPrice(new Book("", "Eminescu",300), BookstoreSubscription.SUBSCRIPTION)
        );

        Assertions.assertEquals("Book title is empty", invalidBookTitleException.getMessage());
    }
}
