package com.github.srwesleyramos.entities;

import com.github.srwesleyramos.base.BaseEntity;
import com.github.srwesleyramos.frame.Frame;
import com.github.srwesleyramos.frame.Utils;

public class Player extends BaseEntity {

    public static final int PLAYER_WIDTH = 26;
    public static final int PLAYER_HEIGHT = 13;
    public static final int PLAYER_OFFSET = 205;
    public static final int PLAYER_SPEED = 4;

    private Bullet bullet;

    public Player(Frame frame) {
        super(frame, PLAYER_WIDTH, PLAYER_HEIGHT);

        this.create(
                (Frame.FRAME_WIDTH / 2) - (PLAYER_WIDTH / 2),
                Frame.FRAME_HEIGHT - PLAYER_HEIGHT - 30
        );
    }

    public void createBullet() {
        if (getFrame().getBullets().contains(bullet)) {
            System.out.println("[debug]: player's bullet has already been fired");
            return;
        }

        bullet = new Bullet(getFrame(), this);
        getFrame().getBullets().add(bullet);
    }

    @Override
    public void applySprite() {
        this.setIcon(Utils.getScaledIcon("/player.png", this.getWidth(), this.getHeight()));
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
