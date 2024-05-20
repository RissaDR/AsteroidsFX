package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Manages lifecycle of entities by initializes resources when the game starts and cleans up when the game ends.
 */
public interface IGamePluginService {

    /**
     * Initializes services or entities when the game starts.
     *
     * Precondition: The game and world are ready to be added with new entities and services.
     * Postcondition: The game will be initialized with new entities and services so that the game can run.
     *
     * @param gameData Contains game and state data.
     * @param world Contains the game world with game entities.
     */
    void start(GameData gameData, World world);

    /**
     * Cleans up resources when the game ends.
     *
     * Precondition: The game can safely remove entities and services.
     * Postcondition: Entities and services are removed.
     *
     * @param gameData Contains game and state data.
     * @param world Contains the game world with game entities.
     */
    void stop(GameData gameData, World world);
}
