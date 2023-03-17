package pl.edu.utp.pso.sphere;

import pl.edu.utp.pso.sphere.property.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Swarm {
    private final Domain domain;
    private final int numberOfEpochs;
    private final int numberOfParticles;
    private int currentEpoch;
    private Position globalMin;
    private final List<Particle> particles = new ArrayList<>();

    public Swarm(Domain domain, int numberOfEpochs, int numberOfParticles) {
        this.domain = domain;
        this.numberOfEpochs = numberOfEpochs;
        this.numberOfParticles = numberOfParticles;
        this.currentEpoch = 1;
        this.globalMin = new Position(100.0, 100.0);

        createSwarm();
    }

    public Domain getDomain() {
        return domain;
    }

    public Position getGlobalMin() {
        return globalMin;
    }

    public void setGlobalMin(Position globalMin) {
        this.globalMin = globalMin;
    }

    private void createSwarm() {
        Random random = new Random();
        double socialCoefficient = random.nextDouble();
        for (int i = 0; i < numberOfParticles; i++) {
            particles.add(new Particle(
                    this, domain.getDomainMin(), domain.getDomainMax(),
                    random.nextDouble(), random.nextDouble(), socialCoefficient
            ));
        }
        System.out.printf("-> The number of epochs: %d%n", numberOfEpochs);
        System.out.printf("-> The number of particles: %d%n", numberOfParticles);
    }

    public void optimizeFunction() {
        System.out.println("Optimization started");
        while (currentEpoch <= numberOfEpochs) {
            particles.forEach(Particle::updateParticle);
            System.out.printf("Epoch %2d: the global minimum at position (%f, %f) = %f%n",
                    currentEpoch,
                    globalMin.getX(),
                    globalMin.getY(),
                    domain.getResult(globalMin)
            );
            currentEpoch++;
        }
        System.out.printf("Optimization complete. The best result is at position (%f, %f) = %f%n",
                globalMin.getX(),
                globalMin.getY(),
                domain.getResult(globalMin)
        );
    }
}
