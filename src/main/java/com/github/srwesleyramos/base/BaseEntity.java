package com.github.srwesleyramos.base;

import com.github.srwesleyramos.layout.GameLayout;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class BaseEntity extends JLabel {

    private final GameLayout game;
    private final int width, height;

    private int x0, y0;

    public BaseEntity(GameLayout game, int width, int height) {
        this.game = game;
        this.width = width;
        this.height = height;
    }

    public void create(int x0, int y0) {
        this.x0 = x0;
        this.y0 = y0;

        // spawning entity

        this.setBounds(x0, y0, width, height);
        this.applySprite();
        this.game.add(this);
    }

    public void applySprite() {
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setOpaque(true);
    }

    public void handleEvent(BaseEntity entity) {
        // not implemented yet | damage
    }

    public void handleEvent(char keyChar) {
        // not implemented yet | keyboard
    }
}
