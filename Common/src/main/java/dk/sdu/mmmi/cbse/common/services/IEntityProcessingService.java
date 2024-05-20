package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Processes individual game logic for entities by updating their state and behaviour during the game loop.
 */
public interface IEntityProcessingService {

    /**
     * Handles the individual process logic for each entity.
     *
     * Precondition: There are entities in the game world that implement the process method.
     * Postcondition: The process method is run for every entity
     *
     * @param gameData Contains game and state data.
     * @param world Contains the game world with game entities.
     */
    void process(GameData gameData, World world);
}
