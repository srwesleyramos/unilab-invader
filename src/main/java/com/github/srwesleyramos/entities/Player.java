package com.github.srwesleyramos.entities;

import com.github.srwesleyramos.base.BaseEntity;
import com.github.srwesleyramos.layout.GameLayout;
import com.github.srwesleyramos.Utils;

public class Player extends BaseEntity {

    public static final int PLAYER_WIDTH = 26;
    public static final int PLAYER_HEIGHT = 13;
    public static final int PLAYER_OFFSET = 205;
    public static final int PLAYER_SPEED = 4;

    private Bullet bullet;

    public Player(GameLayout game) {
        super(game, PLAYER_WIDTH, PLAYER_HEIGHT);

        this.create(
                (GameLayout.FRAME_WIDTH / 2) - (PLAYER_WIDTH / 2),
                GameLayout.FRAME_HEIGHT - PLAYER_HEIGHT - 30
        );
    }

    public void createBullet() {
        if (getGame().getBullets().contains(bullet)) {
            System.out.println("[debug]: player's bullet has already been fired");
            return;
        }

        bullet = new Bullet(getGame(), this);
        getGame().getBullets().add(bullet);
    }

    @Override
    public void applySprite() {
        this.setIcon(Utils.getScaledIcon("/assets/player.png", this.getWidth(), this.getHeight()));
    }

    @Override
    public void handleEvent(char keyChar) {
        if (keyChar == 'a' || keyChar == 'A') {
            this.setLocation(Math.max(this.getX() - PLAYER_SPEED, this.getX0() - PLAYER_OFFSET), this.getY());
        }

        if (keyChar == 'd' || keyChar == 'D') {
            this.setLocation(Math.min(this.getX() + PLAYER_SPEED, this.getX0() + PLAYER_OFFSET), this.getY());
        }

        if (keyChar == ' ') {
            this.createBullet();
        }
    }
}
