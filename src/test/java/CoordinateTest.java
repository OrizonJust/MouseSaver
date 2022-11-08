import org.junit.jupiter.api.Test;
import ru.laverno.Coordinate;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {

    @Test
    public void calculateXTest() {
        Coordinate c = new Coordinate(0,0, true, true);
        assertEquals(1, c.calculateX());
    }

    @Test
    public void calculationYTest() {
        Coordinate c = new Coordinate(0, 0, true, true);
        assertEquals(1, c.calculateY());
    }

    @Test
    public void isFinishTest() {
        Coordinate c = new Coordinate(0,0, true, true);
        assertTrue(c.isFinish());
        c = new Coordinate(1920, 1080, true, true);
        assertFalse(c.isFinish());
    }

    @Test
    public void changeDirection() {
        Coordinate c = new Coordinate(1919, 100, true, true);
        c.calculateX();
        c.calculateX();
        assertEquals(1918, c.calculateX());

        c = new Coordinate(100, 1079, true, true);
        c.calculateY();
        c.calculateY();
        assertEquals(1078, c.calculateY());

        c = new Coordinate(1, 100, false, true);
        c.calculateX();
        c.calculateX();
        assertEquals(2, c.calculateX());

        c = new Coordinate(100, 1, true, false);
        c.calculateY();
        c.calculateY();
        assertEquals(2, c.calculateY());
    }
}
