package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PlayerControlSystemTest {

    private PlayerControlSystem playerControlSystem;
    private GameData gameData;
    private World world;
    private Player player;

    @Mock
    private BulletSPI mockBulletSPI;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameData = new GameData();
        world = new World();
        playerControlSystem = new PlayerControlSystem();

        gameData.setDisplayWidth(800);
        gameData.setDisplayHeight(600);
        resetGameKeys();

        player = new Player();
        player.setX(400);
        player.setY(300);
        player.setRadius(5);
        world.addEntity(player);
        reset(mockBulletSPI);
    }

    private void resetGameKeys() {
        gameData.getKeys().setKey(GameKeys.LEFT, false);
        gameData.getKeys().setKey(GameKeys.RIGHT, false);
        gameData.getKeys().setKey(GameKeys.UP, false);
        gameData.getKeys().setKey(GameKeys.SPACE, false);
    }

    @Test
    void testPlayerMovement() {
        gameData.getKeys().setKey(GameKeys.UP, true);
        playerControlSystem.process(gameData, world);
        double expectedX = 400 + Math.cos(Math.toRadians(player.getRotation()));
        double expectedY = 300 + Math.sin(Math.toRadians(player.getRotation()));
        assert(player.getX() == expectedX);
        assert(player.getY() == expectedY);
        resetGameKeys();
    }

    @Test
    void testPlayerRotation() {
        gameData.getKeys().setKey(GameKeys.RIGHT, true);
        double initialRotation = player.getRotation();
        playerControlSystem.process(gameData, world);
        assert(player.getRotation() == initialRotation + 5);
        resetGameKeys();
    }

    @Test
    void testPlayerShooting() throws Exception {
        mockBulletSPI = Mockito.mock(BulletSPI.class);

        Bullet bullet = new Bullet(player.getID());
        //  when(mockBulletSPI.createBullet(player, gameData, player.getID())).thenReturn(bullet);

        gameData.getKeys().setKey(GameKeys.SPACE, true);
        playerControlSystem.process(gameData, world);

        // verify(mockBulletSPI).createBullet(player, gameData, player.getID());

        resetGameKeys();
    }
}
