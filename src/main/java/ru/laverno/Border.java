package ru.laverno;

import static java.awt.Toolkit.getDefaultToolkit;

public enum Border {

    UPPER(0, getDefaultToolkit().getScreenSize().width),
    RIGHT(0, getDefaultToolkit().getScreenSize().height),
    LOWER(getDefaultToolkit().getScreenSize().width, 0),
    LEFT(getDefaultToolkit().getScreenSize().height, 0);

    private final int firstPoint;
    private final int secondPoint;

    Border(int firstPoint, int secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public int getFirstPoint() {
        return this.firstPoint;
    }

    public int getSecondPoint() {
        return this.secondPoint;
    }
}
