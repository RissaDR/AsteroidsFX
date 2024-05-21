package dk.sdu.mmmi.cbse.common.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.util.UUID;

public class Bullet extends Entity {
    private String shooterId;

    public Bullet(String shooterId) {
        this.shooterId = shooterId;
    }

    public String getShooterId() {
        return shooterId;
    }

    public void setShooterId(String shooterId) {
        this.shooterId = shooterId;
    }
}
