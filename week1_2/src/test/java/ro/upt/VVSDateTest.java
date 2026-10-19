package ro.upt;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VVSDateTest {

    @Test
    public void testSameDate() {
        VVSDate d1 = new VVSDate(15, 6, 2023);
        VVSDate d2 = new VVSDate(15, 6, 2023);

        // between the same dates should be 0
        assertEquals(0, d1.getDays(d2));
    }

    @Test
    public void testConsecutiveDaysInSameMonth() {
        VVSDate d1 = new VVSDate(10, 5, 2023);
        VVSDate d2 = new VVSDate(5, 5, 2023);

        // positive distance
        assertEquals(5, d1.getDays(d2));
        // negative distance (reverse order)
        assertEquals(-5, d2.getDays(d1));
    }

    @Test
    public void testMonthBoundary_RegularYear() {
        VVSDate march1st = new VVSDate(1, 3, 2023);
        VVSDate feb28th = new VVSDate(28, 2, 2023);

        // in a non-leap year, 1 March is exactly 1 day after Feb 28
        assertEquals(1, march1st.getDays(feb28th));
    }

    @Test
    public void testMonthBoundary_LeapYear() {
        VVSDate march1st = new VVSDate(1, 3, 2024); // 2024 is a leap year
        VVSDate feb28th = new VVSDate(28, 2, 2024);

        // in a leap year, 1 March is 2 days after Feb 28 (bcs of Feb 29)
        assertEquals(2, march1st.getDays(feb28th));
    }

    @Test
    public void testYearBoundary() {
        VVSDate newYear = new VVSDate(1, 1, 2024);
        VVSDate newYearsEve = new VVSDate(31, 12, 2023);

        // 1 day difference across year limits
        assertEquals(1, newYear.getDays(newYearsEve));
    }

    @Test
    public void testFullYearDistance_RegularYear() {
        VVSDate d1 = new VVSDate(1, 1, 2024);
        VVSDate d2 = new VVSDate(1, 1, 2023); // 2023 is regular

        assertEquals(365, d1.getDays(d2));
    }

    @Test
    public void testFullYearDistance_LeapYear() {
        VVSDate d1 = new VVSDate(1, 1, 2025);
        VVSDate d2 = new VVSDate(1, 1, 2024); // 2024 is a leap year (include 29 Feb)

        assertEquals(366, d1.getDays(d2));
    }

    @Test
    public void testCenturyYear_NotLeapYear() {
        VVSDate march1st = new VVSDate(1, 3, 1900); // 1900 is divisible by 4, but NOT by 400
        VVSDate feb28th = new VVSDate(28, 2, 1900);

        // Should be 1 day (no 29 Feb in 1900)
        assertEquals(1, march1st.getDays(feb28th));
    }

    @Test
    public void testCenturyYear_LeapYear() {
        VVSDate march1st = new VVSDate(1, 3, 2000); // 2000 is divisible by 400
        VVSDate feb28th = new VVSDate(28, 2, 2000);

        // Should be 2 days (29 Feb exists in 2000)
        assertEquals(2, march1st.getDays(feb28th));
    }
}