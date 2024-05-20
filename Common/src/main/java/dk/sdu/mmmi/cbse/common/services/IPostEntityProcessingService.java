package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Processes logic after all entities have updated.
 */
public interface IPostEntityProcessingService {

    /**
     * Processes conditions after all entities have updated.
     *
     * Precondition: All IEntityProcessingServices have run updates.
     * Postcondition: The world is changed according to conditions post-entity update.
     *
     * @param gameData Contains game and state data.
     * @param world Contains the game world with game entities.
     */
    void process(GameData gameData, World world);
}
