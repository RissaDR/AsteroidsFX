package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.asteroid.AsteroidSplitterImpl;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.enemysystem.Enemy;
import dk.sdu.mmmi.cbse.playersystem.Player;

public class CollisionDetector implements IPostEntityProcessingService {

    private AsteroidSplitterImpl asteroidSplitter = new AsteroidSplitterImpl();

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {
                if (entity1 == entity2) continue;

                if (collides(entity1, entity2)) {
                    if ((entity1 instanceof Bullet && entity2 instanceof Asteroid) ||
                            (entity2 instanceof Bullet && entity1 instanceof Asteroid)) {
                        handleBulletAsteroidCollision((Bullet) (entity1 instanceof Bullet ? entity1 : entity2),
                                (Asteroid) (entity1 instanceof Asteroid ? entity1 : entity2), world);
                    } else if ((entity1 instanceof Player || entity1 instanceof Enemy) && entity2 instanceof Asteroid ||
                            (entity2 instanceof Player || entity2 instanceof Enemy) && entity1 instanceof Asteroid) {
                        world.removeEntity(entity1);
                        world.removeEntity(entity2);
                    } else if ((entity1 instanceof Bullet && entity2 instanceof Player && !((Bullet) entity1).getShooterId().equals(entity2.getID())) ||
                            (entity2 instanceof Bullet && entity1 instanceof Player && !((Bullet) entity2).getShooterId().equals(entity1.getID())) ||
                            (entity1 instanceof Bullet && entity2 instanceof Enemy && !((Bullet) entity1).getShooterId().equals(entity2.getID())) ||
                            (entity2 instanceof Bullet && entity1 instanceof Enemy && !((Bullet) entity2).getShooterId().equals(entity1.getID()))) {
                        world.removeEntity(entity1);
                        world.removeEntity(entity2);
                    }
                }
            }
        }
    }

    private void handleBulletAsteroidCollision(Bullet bullet, Asteroid asteroid, World world) {
        world.removeEntity(bullet);
        if (asteroid.getRadius() > 10) {
            asteroidSplitter.createSplitAsteroid(asteroid, world);
            world.removeEntity(asteroid);
        } else {
            world.removeEntity(asteroid);
        }
    }

    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }

}
