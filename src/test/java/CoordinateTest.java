import org.junit.jupiter.api.Test;
import ru.laverno.Coordinate;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {

    @Test
    public void calculateXTest() {
        Coordinate c = new Coordinate.CoordinateBuilder(1, 1).build();
        assertEquals(1, c.calculateX());
    }

    @Test
    public void calculationYTest() {
        Coordinate c = new Coordinate.CoordinateBuilder(1, 1).build();
        assertEquals(1, c.calculateY());
    }

    @Test
    public void isFinishTest() {
        Coordinate c = new Coordinate.CoordinateBuilder(1, 1).build();
        assertFalse(c.isFinish());
        c = new Coordinate.CoordinateBuilder(1, 1).setX(1920).setY(1080).build();
        assertTrue(c.isFinish());
    }

    @Test
    public void changeDirection() {
        Coordinate c = new Coordinate.CoordinateBuilder(1, 1).setX(1919).setY(100).build();
        c.calculateX();
        c.calculateX();
        assertEquals(1918, c.calculateX());

        c = new Coordinate.CoordinateBuilder(1,1).setX(100).setY(1079).build();
        c.calculateY();
        c.calculateY();
        assertEquals(1078, c.calculateY());

        c = new Coordinate.CoordinateBuilder(1, 1).setX(1).setY(100).setRightDirectionHorizontal(false).build();
        c.calculateX();
        c.calculateX();
        assertEquals(2, c.calculateX());

        c = new Coordinate.CoordinateBuilder(1, 1).setX(100).setY(1).setDownDirectionVertical(false).build();
        c.calculateY();
        c.calculateY();
        assertEquals(2, c.calculateY());
    }
}
