package com.github.srwesleyramos.entities;

import com.github.srwesleyramos.base.BaseEntity;
import com.github.srwesleyramos.frame.Frame;
import com.github.srwesleyramos.frame.Utils;

public class Player extends BaseEntity {

    public static final int PLAYER_WIDTH = 26;
    public static final int PLAYER_HEIGHT = 13;
    public static final int PLAYER_OFFSET = 205;
    public static final int PLAYER_SPEED = 4;

    public Player(Frame frame) {
        super(frame, PLAYER_WIDTH, PLAYER_HEIGHT);

        this.spawn(
                (Frame.FRAME_WIDTH / 2) - (PLAYER_WIDTH / 2),
                Frame.FRAME_HEIGHT - PLAYER_HEIGHT - 30
        );
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
    }
}
