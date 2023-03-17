package pl.edu.utp.pso;

import pl.edu.utp.pso.sphere.Domain;
import pl.edu.utp.pso.sphere.Swarm;
import pl.edu.utp.pso.sphere.property.Position;

public class Start {

    public static void main(String[] args) {

        Domain ackley = new Domain();
        ackley.setFunction((x, y) ->
                (-20.0 * Math.exp(-0.2 * Math.sqrt(0.5 * (Math.pow(x, 2.0) + Math.pow(y, 2.0)))))
                        - (Math.exp(0.5 * (Math.cos(2.0 * Math.PI * x) + Math.cos(2.0 * Math.PI * y))))
                        + Math.E + 20.0);
        ackley.setDomainMin(new Position(-5.0, -5.0));
        ackley.setDomainMax(new Position(5.0, 5.0));

        Domain beale = new Domain();
        beale.setFunction((x, y) ->
                Math.pow(1.5 - x + (x * y), 2.0)
                        + Math.pow(2.25 - x + (x * Math.pow(y, 2.0)), 2.0)
                        + Math.pow(2.625 - x + (x * Math.pow(y, 3.0)), 2.0));
        beale.setDomainMin(new Position(-4.5, -4.5));
        beale.setDomainMax(new Position(4.5, 4.5));

        Domain goldsteinPrice = new Domain();
        goldsteinPrice.setFunction((x, y) ->
                (1.0 + Math.pow(x + y + 1.0, 2.0)
                        * (19.0 - (14.0 * x) + (3.0 * Math.pow(x, 2.0)) - (14.0 * y)
                        + (6.0 * x * y) + (3.0 * Math.pow(y, 2.0))))
                        * (30.0 + Math.pow((2.0 * x) - (3.0 * y), 2.0)
                        * (18.0 - (32.0 * x) + (12.0 * Math.pow(x, 2.0)) + (48.0 * y)
                        - (36.0 * x * y) + (27.0 * Math.pow(y, 2.0)))));
        goldsteinPrice.setDomainMin(new Position(-2.0, -2.0));
        goldsteinPrice.setDomainMax(new Position(2.0, 2.0));

        Domain booth = new Domain();
        booth.setFunction((x, y) ->
                Math.pow(x + (2.0 * y) - 7.0, 2.0) + Math.pow((2.0 * x) + y - 5, 2.0));
        booth.setDomainMin(new Position(-10, -10));
        booth.setDomainMax(new Position(10, 10));

        Domain matyas = new Domain();
        matyas.setFunction((x, y) ->
                (0.26 * (Math.pow(x, 2.0) + Math.pow(y, 2.0))) - (0.48 * x * y));
        matyas.setDomainMin(new Position(-10, -10));
        matyas.setDomainMax(new Position(10, 10));

        System.out.println("\n*** Optimization of the Ackley function ***");
        Swarm swarm1 = new Swarm(ackley, 30, 50);
        swarm1.optimizeFunction();

        System.out.println("\n*** Optimization of the Beale function ***");
        Swarm swarm2 = new Swarm(beale, 30, 100);
        swarm2.optimizeFunction();

        System.out.println("\n*** Optimization of the Goldstein-Price function ***");
        Swarm swarm3 = new Swarm(goldsteinPrice, 30, 100);
        swarm3.optimizeFunction();

        System.out.println("\n*** Optimization of the Booth function ***");
        Swarm swarm4 = new Swarm(booth, 30, 100);
        swarm4.optimizeFunction();

        System.out.println("\n*** Optimization of the Matyas function ***");
        Swarm swarm5 = new Swarm(matyas, 30, 100);
        swarm5.optimizeFunction();
    }
}
