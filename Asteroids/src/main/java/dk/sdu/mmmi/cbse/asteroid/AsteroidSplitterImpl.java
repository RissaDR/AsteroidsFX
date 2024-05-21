package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;

import java.util.Random;

public class AsteroidSplitterImpl implements IAsteroidSplitter {

    private final Random random = new Random();

    @Override
    public void createSplitAsteroid(Entity e, World world) {
        float originalSize = e.getRadius();

        float minSplitSize = 5.0f;

        if (originalSize > minSplitSize) {
            float newSize = originalSize / 2.0f;

            for (int i = 0; i < 2; i++) {
                Entity newAsteroid = new Asteroid();
                newAsteroid.setRadius(newSize);
                newAsteroid.setX(e.getX() + (random.nextInt(10) - 5));
                newAsteroid.setY(e.getY() + (random.nextInt(10) - 5));
                newAsteroid.setRotation(random.nextDouble() * 360.0);

                world.addEntity(newAsteroid);
            }
        } else {
            world.removeEntity(e);
        }
    }
}
