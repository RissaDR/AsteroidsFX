package dk.sdu.mmmi.cbse.common.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

import java.util.UUID;

public interface BulletSPI {
    Entity createBullet(Entity e, GameData gameData, String id);
}
