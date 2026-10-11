package ro.upt;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiscountCalculatorTest {
    private DiscountCalculator discountCalculator;

    @BeforeEach
    public void setUp() {
        discountCalculator = new DiscountCalculator();
    }

    @AfterEach
    public void cleanup() {
        discountCalculator = null;
    }

    @Test
    public void testNoCouponPriceGraterThan100() {

        double result = discountCalculator.getDiscount(120, false);
        Assertions.assertEquals(20, result);
    }

    @Test
    public void testNoCouponPriceLowerThan100() {
        double result = discountCalculator.getDiscount(15, false);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCupon(){
        double result = discountCalculator.getDiscount(10, true);
        Assertions.assertEquals(30, result);
    }

    @Test
    public void testInvalidPrice(){
        InvalidPriceException ex =Assertions.assertThrows(
                InvalidPriceException.class,
                () -> discountCalculator.getDiscount(-1, true)
        );

        Assertions.assertEquals("Price is negative", ex.getMessage());
    }

}
