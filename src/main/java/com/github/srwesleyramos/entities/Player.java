package com.github.srwesleyramos.entities;

import com.github.srwesleyramos.base.BaseEntity;
import com.github.srwesleyramos.frame.Frame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

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
        URL iconUrl = getClass().getResource("/player.png");

        if (iconUrl == null) {
            throw new RuntimeException("player icon not found!");
        }

        Image image = new ImageIcon(iconUrl)
                .getImage()
                .getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);

        this.setIcon(new ImageIcon(image));
    }
}
