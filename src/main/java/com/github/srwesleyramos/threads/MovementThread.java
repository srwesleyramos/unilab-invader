package com.github.srwesleyramos.threads;

import com.github.srwesleyramos.base.BaseThread;
import com.github.srwesleyramos.entities.Enemy;
import com.github.srwesleyramos.frame.Frame;

import java.util.List;

public class MovementThread extends BaseThread {

    private int path = 1;

    public MovementThread(Frame frame) {
        super(frame, 50);
    }

    @Override
    public void run() {
        // enemies still alive?

        if (this.getFrame().getEnemies().isEmpty()) {
            this.getTimer().stop();
            return;
        }

        // updating new location

        List<Enemy> enemies = this.getFrame().getEnemies();

        for (Enemy enemy : enemies) {
            if (path == 1) {
                enemy.setLocation(Math.max(enemy.getX() - Enemy.ENEMY_SPEED, enemy.getX0() - Enemy.ENEMY_OFFSET), enemy.getY());
            } else {
                enemy.setLocation(Math.min(enemy.getX() + Enemy.ENEMY_SPEED, enemy.getX0() + Enemy.ENEMY_OFFSET), enemy.getY());
            }
        }

        // trying to calculate new path

        Enemy enemy = enemies.getFirst();

        if (Math.abs(enemy.getX() - enemy.getX0()) >= 50) {
            path *= -1;
        }
    }
}
