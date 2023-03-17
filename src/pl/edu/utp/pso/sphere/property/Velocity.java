package pl.edu.utp.pso.sphere.property;

import java.util.Arrays;

public class Velocity {
    private double x;
    private double y;

    public Velocity(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static Velocity add(Velocity... velocities) {
        return new Velocity(
                Arrays.stream(velocities).mapToDouble(Velocity::getX).sum(),
                Arrays.stream(velocities).mapToDouble(Velocity::getY).sum()
        );
    }

    public static Velocity subtract(Position bestPosition, Position currentPosition) {
        return new Velocity(
                bestPosition.getX() - currentPosition.getX(),
                bestPosition.getY() - currentPosition.getY()
        );
    }

    public Velocity multiply(double coefficient) {
        return new Velocity(
                coefficient * this.x,
                coefficient * this.y
        );
    }
}
