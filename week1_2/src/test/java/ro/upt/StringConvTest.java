package ro.upt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StringConvTest {
    private StringConv stringConv;

    @BeforeEach
    public void setUp() {
        stringConv = new StringConv();
    }

    @Test
    public void testNormalConv() {
        int result = stringConv.strToInt("1234");

        Assertions.assertEquals(1234, result);
    }

    @Test
    public void testZeroConv() {
        int result = stringConv.strToInt("0");

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testZeroStartingConv() {
        int result = stringConv.strToInt("01234");
        Assertions.assertEquals(1234, result);
    }

    @Test
    public void testNegativeConv(){
        int result = stringConv.strToInt("-1234");
        Assertions.assertEquals(-1234, result);
    }

    @Test
    public void testLettersConv() {
        InvalidStringException invalidStringException = Assertions.assertThrows(
                InvalidStringException.class,
                () -> stringConv.strToInt("a1234")
        );
        Assertions.assertEquals("Invalid String Input", invalidStringException.getMessage());
    }

    @Test
    public void testNullConv(){
        InvalidStringException invalidStringException = Assertions.assertThrows(
                InvalidStringException.class,
                () -> stringConv.strToInt(null)
        );

        Assertions.assertEquals("Invalid Null String", invalidStringException.getMessage());
    }

    @Test
    public void testExceedsMaxIntLimit() {
        NumberFormatException exception = Assertions.assertThrows(
                NumberFormatException.class,
                () -> stringConv.strToInt("2147483648")
        );
        Assertions.assertEquals("Number exceeds integer limit", exception.getMessage());
    }

    @Test
    public void testExceedsMinIntLimit() {
        NumberFormatException exception = Assertions.assertThrows(
                NumberFormatException.class,
                () -> stringConv.strToInt("-2147483649")
        );
        Assertions.assertEquals("Number exceeds integer limit", exception.getMessage());
    }
}
