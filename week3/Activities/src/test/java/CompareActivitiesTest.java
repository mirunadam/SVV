import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.upt.ActivityType;
import ro.upt.CompareActivities;
import ro.upt.IncorrectNumberOfParameters;
import ro.upt.IncorrectValueException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CompareActivitiesTest {
    private CompareActivities compareActivities;
    @BeforeEach
    public void setUp() {
        compareActivities = new CompareActivities(500);
    }

    @Test
    public void testNullType() {
        assertThrows(IncorrectValueException.class,
                () -> compareActivities.compare(null, 1));
    }

    // RUN
    @Test
    public void testRun() {
        // 3 * 100 = 300 -> 500 - 300 = 200
        assertEquals(200, compareActivities.compare(ActivityType.RUN, 3));
    }

    @Test
    public void testRunInvalidKm() {
        assertThrows(IncorrectValueException.class,
                () -> compareActivities.compare(ActivityType.RUN, 0));
    }

    @Test
    public void testRunWrongNumberOfParameters() {
        assertThrows(IncorrectNumberOfParameters.class,
                () -> compareActivities.compare(ActivityType.RUN, 1, 2));
    }

    // BIKE
    @Test
    public void testBike() {
        // 2 * 5 * 10 = 100 -> 500 - 100 = 400
        assertEquals(400, compareActivities.compare(ActivityType.BIKE, 2, 5));
    }

    @Test
    public void testBikeInvalidGears() {
        assertThrows(IncorrectValueException.class,
                () -> compareActivities.compare(ActivityType.BIKE, 2, 0));
    }

    @Test
    public void testBikeWrongNumberOfParameters() {
        assertThrows(IncorrectNumberOfParameters.class,
                () -> compareActivities.compare(ActivityType.BIKE, 2));
    }

    // SWIM
    @Test
    public void testSwim() {
        // 2 * 50 - 20 = 80 -> 500 - 80 = 420
        assertEquals(420, compareActivities.compare(ActivityType.SWIM, 2, 20));
    }

    @Test
    public void testSwimInvalidTemperature() {
        assertThrows(IncorrectValueException.class,
                () -> compareActivities.compare(ActivityType.SWIM, 2, 31));
    }

    @Test
    public void testSwimWrongNumberOfParameters() {
        assertThrows(IncorrectNumberOfParameters.class,
                () -> compareActivities.compare(ActivityType.SWIM, 2));
    }

    // UNKNOWNACTIVITY
    @Test
    public void testUnknownActivity() {
        assertEquals(500, compareActivities.compare(ActivityType.UNKNOWNACTIVITY));
    }

}
