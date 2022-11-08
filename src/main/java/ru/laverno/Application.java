package ru.laverno;

import java.awt.*;

public class Application {

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            Coordinate c = new Coordinate(0, 0, true, true);
            boolean flag = true;
            while (flag) {
                robot.mouseMove(c.calculateX(), c.calculateY());
                flag = c.isFinish();
                Thread.sleep(2);
            }
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
