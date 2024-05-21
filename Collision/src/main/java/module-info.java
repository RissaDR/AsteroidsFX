import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    requires CommonAsteroids;
    requires CommonBullet;
    requires Player;
    requires Enemy;
    requires Asteroid;
    requires spring.beans;
    requires spring.context;
    requires spring.web;
    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.collisionsystem.CollisionDetector;
}