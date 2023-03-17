package pl.edu.utp.pso.sphere;

import pl.edu.utp.pso.sphere.property.Position;

import java.util.function.BiFunction;

public class Domain {
    private BiFunction<Double, Double, Double> function;
    private Position domainMin;
    private Position domainMax;

    public BiFunction<Double, Double, Double> getFunction() {
        return function;
    }

    public void setFunction(BiFunction<Double, Double, Double> function) {
        this.function = function;
    }

    public Position getDomainMin() {
        return domainMin;
    }

    public void setDomainMin(Position domainMin) {
        this.domainMin = domainMin;
    }

    public Position getDomainMax() {
        return domainMax;
    }

    public void setDomainMax(Position domainMax) {
        this.domainMax = domainMax;
    }

    public double getResult(Position position) {
        return function.apply(position.getX(), position.getY());
    }
}
