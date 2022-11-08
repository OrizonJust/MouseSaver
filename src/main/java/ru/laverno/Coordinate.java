package ru.laverno;

import static ru.laverno.Border.*;

public class Coordinate {

    private int x;
    private int y;
    private boolean directionHorizontal; //true = right, false = left
    private boolean directionVertical; //true = down, false = up

    public Coordinate(int startX, int startY, boolean directionHorizontal, boolean directionVertical) {
        if (startX < UPPER.getFirstPoint()
                || startY < RIGHT.getFirstPoint()
                ||startX > UPPER.getSecondPoint()
                || startY > RIGHT.getSecondPoint()) {
            throw new IllegalArgumentException();
        }

        this.x = startX;
        this.y = startY;
        this.directionHorizontal = directionHorizontal;
        this.directionVertical = directionVertical;
    }

    public int calculateX() {
        checkHorizontalBorder();

        if (directionHorizontal) return ++x;
        else return --x;
    }

    public int calculateY() {
        checkVerticalBorder();

        if (directionVertical) return ++y;
        else return --y;
    }

    private void checkHorizontalBorder() {
        if (x == UPPER.getSecondPoint()) {
            directionHorizontal = false;
        }
        if (x == LOWER.getSecondPoint()) {
            directionHorizontal = true;
        }
    }

    private void checkVerticalBorder() {
        if (y == LEFT.getSecondPoint()) {
            directionVertical = true;
        }
        if (y == RIGHT.getSecondPoint()) {
            directionVertical = false;
        }
    }

    public boolean isFinish() {
        return !(x == LOWER.getFirstPoint() && y == RIGHT.getSecondPoint());
    }
}
