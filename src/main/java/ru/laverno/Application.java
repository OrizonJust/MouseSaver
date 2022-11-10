package ru.laverno;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.tan;
import static java.lang.Math.toRadians;

public class Application {

    static boolean exit = false;

    public static void main(String[] args) {
        printUI();
        double degree = args.length == 0 ? 45 : Double.parseDouble(args[0]);
        double tan = tan(toRadians(degree));

        Coordinate c = new Coordinate.CoordinateBuilder(tan, 1 / tan).build();
        try {
            Robot robot = new Robot();
            while (!exit) {
                robot.mouseMove(c.calculateX(), c.calculateY());
                exit = c.isFinish();
            }
        } catch (Exception ex) {
            throw new RuntimeException();
        } finally {
            System.out.println(c.getCounterChangeDirection());
        }
    }

    private static void printUI() {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.addKeyListener(new KeyListenerToClose());
    }
}
