package com.github.srwesleyramos.threads;

import com.github.srwesleyramos.base.BaseEntity;
import com.github.srwesleyramos.base.BaseThread;
import com.github.srwesleyramos.entities.Bullet;
import com.github.srwesleyramos.layout.GameLayout;
import com.github.srwesleyramos.Utils;

import java.util.ArrayList;
import java.util.List;

public class ProjectileThread extends BaseThread {

    public static final int BULLET_MIN_HEIGHT = 20;
    public static final int BULLET_MAX_HEIGHT = 480;

    public ProjectileThread(GameLayout game) {
        super(game, 50);
    }

    @Override
    public void run() {
        List<BaseEntity> entities = new ArrayList<>(getAllEntities());
        List<Bullet> bullets = new ArrayList<>(getGame().getBullets());

        for (Bullet bullet : bullets) {
            bullet.setLocation(bullet.getX(), bullet.getY() + (Bullet.BULLET_SPEED * bullet.getDirection()));

            if (bullet.getY() < BULLET_MIN_HEIGHT || bullet.getY() > BULLET_MAX_HEIGHT) {
                bullet.handleEvent((BaseEntity) null);
            } else {
                Utils.checkCollisions(bullet, entities);
            }
        }
    }

    public List<BaseEntity> getAllEntities() {
        List<BaseEntity> entities = new ArrayList<>(getGame().getBullets());

        entities.add(getGame().getPlayer());
        entities.addAll(getGame().getEnemies());

        return entities;
    }
}
