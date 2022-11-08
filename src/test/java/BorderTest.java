import org.junit.jupiter.api.Test;

import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.laverno.Border.*;

public class BorderTest {

    private final Dimension screenSize = getDefaultToolkit().getScreenSize();

    @Test
    public void upperBorderTest() {
        assertEquals(0, UPPER.getFirstPoint());
        assertEquals(screenSize.width, UPPER.getSecondPoint());
    }

    @Test
    public void rightBorderTest() {
        assertEquals(0, RIGHT.getFirstPoint());
        assertEquals(screenSize.height, RIGHT.getSecondPoint());
    }

    @Test
    public void lowerBorderTest() {
        assertEquals(screenSize.width, LOWER.getFirstPoint());
        assertEquals(0, LOWER.getSecondPoint());
    }

    @Test
    public void leftBorderTest() {
        assertEquals(screenSize.height, LEFT.getFirstPoint());
        assertEquals(0, LEFT.getSecondPoint());
    }
}
