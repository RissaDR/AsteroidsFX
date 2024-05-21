package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class EnemyPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world) {
        int initialCount = 5;
        for (int i = 0; i < initialCount; i++) {
            Entity enemy = createEnemy(gameData);
            world.addEntity(enemy);
        }
    }

    private Entity createEnemy(GameData gameData) {
        Entity enemy = new Enemy();
        Random rnd = new Random();
        enemy.setPolygonCoordinates(-5,-5,10,0,-5,5);
        enemy.setX(rnd.nextDouble() * gameData.getDisplayWidth());
        enemy.setY(rnd.nextDouble() * gameData.getDisplayHeight());
        enemy.setRadius(8);
        return enemy;
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {
            world.removeEntity(enemy);
        }
    }
}
