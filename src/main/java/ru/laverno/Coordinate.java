package ru.laverno;

import lombok.Getter;

import static ru.laverno.Border.*;

@Getter
public class Coordinate {

    private double x;
    private double y;
    private final double xStep;
    private final double yStep;
    private boolean rightDirectionHorizontal;
    private boolean downDirectionVertical;
    private int counterChangeDirection;

    private Coordinate(CoordinateBuilder builder) {
        if (builder.x < UPPER.getFirstPoint()
                || builder.y < RIGHT.getFirstPoint()
                || builder.x > UPPER.getSecondPoint()
                || builder.y > RIGHT.getSecondPoint()) {
            throw new IllegalArgumentException();
        }

        this.x = builder.x;
        this.y = builder.y;
        this.rightDirectionHorizontal = builder.rightDirectionHorizontal;
        this.downDirectionVertical = builder.downDirectionVertical;
        this.xStep = builder.xStep;
        this.yStep = builder.yStep;
        this.counterChangeDirection = -2;
    }

    public int calculateX() {
        checkHorizontalBorder();

        if (rightDirectionHorizontal) return (int) (x += xStep);
        else return (int) (x -= xStep);
    }

    public int calculateY() {
        checkVerticalBorder();

        if (downDirectionVertical) return (int) (y += yStep);
        else return (int) (y -= yStep);
    }

    private void checkHorizontalBorder() {
        if (x >= UPPER.getSecondPoint()) {
            rightDirectionHorizontal = false;
            counterChangeDirection++;
        }
        if (x <= LOWER.getSecondPoint()) {
            rightDirectionHorizontal = true;
            counterChangeDirection++;
        }
    }

    private void checkVerticalBorder() {
        if (y <= LEFT.getSecondPoint()) {
            downDirectionVertical = true;
            counterChangeDirection++;
        }
        if (y >= RIGHT.getSecondPoint()) {
            downDirectionVertical = false;
            counterChangeDirection++;
        }
    }

    public boolean isFinish() {
        return x == LOWER.getFirstPoint() && y == RIGHT.getSecondPoint();
    }

    public static class CoordinateBuilder {

        private double x;
        private double y;
        private final double xStep;
        private final double yStep;
        private boolean rightDirectionHorizontal;
        private boolean downDirectionVertical;

        public CoordinateBuilder(final double xStep, final double yStep) {
            this.xStep = xStep;
            this.yStep = yStep;
            this.rightDirectionHorizontal = true;
            this.downDirectionVertical = true;
        }

        public CoordinateBuilder setX(final double x) {
            this.x = x;
            return this;
        }

        public CoordinateBuilder setY(final double y) {
            this.y = y;
            return this;
        }

        public CoordinateBuilder setRightDirectionHorizontal(final boolean rightDirectionHorizontal) {
            this.rightDirectionHorizontal = rightDirectionHorizontal;
            return this;
        }

        public CoordinateBuilder setDownDirectionVertical(final boolean downDirectionVertical) {
            this.downDirectionVertical = downDirectionVertical;
            return this;
        }

        public Coordinate build() {
            return new Coordinate(this);
        }
    }

}
