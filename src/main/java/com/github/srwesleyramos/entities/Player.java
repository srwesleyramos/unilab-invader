package com.github.srwesleyramos.entities;

import com.github.srwesleyramos.base.BaseEntity;
import com.github.srwesleyramos.frame.Frame;
import com.github.srwesleyramos.frame.Utils;

public class Player extends BaseEntity {

    public static final int PLAYER_WIDTH = 26;
    public static final int PLAYER_HEIGHT = 13;

    public Player(Frame frame) {
        super(frame, PLAYER_WIDTH, PLAYER_HEIGHT);

        this.spawn(
                (Frame.FRAME_WIDTH / 2) - (PLAYER_WIDTH / 2),
                (Frame.FRAME_HEIGHT - 40) - PLAYER_HEIGHT - 30
        );
    }

    @Override
    public void applySprite() {
        this.setIcon(Utils.getScaledIcon("/player.png", this.getWidth(), this.getHeight()));
    }
}
