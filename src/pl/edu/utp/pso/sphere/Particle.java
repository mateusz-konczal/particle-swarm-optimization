package pl.edu.utp.pso.sphere;

import pl.edu.utp.pso.sphere.property.Position;
import pl.edu.utp.pso.sphere.property.Velocity;

import java.util.Random;

public class Particle {
    private final Swarm swarm;
    private final Position minPosition;
    private final Position maxPosition;
    private final double inertiaCoefficient;
    private final double personalCoefficient;
    private final double socialCoefficient;
    private Position currentPosition;
    private Position localMin;
    private Velocity currentVelocity;
    private final Random random = new Random();

    public Particle(Swarm swarm, Position minPosition, Position maxPosition, double inertiaCoefficient,
                    double personalCoefficient, double socialCoefficient) {
        this.swarm = swarm;
        this.minPosition = minPosition;
        this.maxPosition = maxPosition;
        this.inertiaCoefficient = inertiaCoefficient;
        this.personalCoefficient = personalCoefficient;
        this.socialCoefficient = socialCoefficient;

        initializeParticle();
    }

    private void initializeParticle() {
        currentPosition = new Position(
                minPosition.getX() + (random.nextDouble() * Math.abs(maxPosition.getX() - minPosition.getX())),
                minPosition.getY() + (random.nextDouble() * Math.abs(maxPosition.getY() - minPosition.getY()))
        );
        localMin = currentPosition;

        if (swarm.getDomain().getResult(localMin) < swarm.getDomain().getResult(swarm.getGlobalMin())) {
            swarm.setGlobalMin(localMin);
        }

        currentVelocity = new Velocity(0.0, 0.0);
    }

    public void updateParticle() {
        currentVelocity = Velocity.add(
                currentVelocity.multiply(inertiaCoefficient),
                Velocity
                        .subtract(localMin, currentPosition)
                        .multiply(random.nextDouble() * personalCoefficient),
                Velocity
                        .subtract(swarm.getGlobalMin(), currentPosition)
                        .multiply(random.nextDouble() * socialCoefficient)
        );

        currentPosition = currentPosition.add(currentVelocity);
        if (swarm.getDomain().getResult(currentPosition) < swarm.getDomain().getResult(localMin)) {
            localMin = currentPosition;
            if (swarm.getDomain().getResult(localMin) < swarm.getDomain().getResult(swarm.getGlobalMin())) {
                swarm.setGlobalMin(localMin);
            }
        }
    }
}
