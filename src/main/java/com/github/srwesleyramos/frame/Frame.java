package com.github.srwesleyramos.frame;

import com.github.srwesleyramos.entities.Player;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 500;

    public Frame() {
        this.setTitle("SPACE INVADERS");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        this.drawEntities();
        this.drawProperties();
    }

    private void drawEntities() {
        // PLAYER

        new Player(this);

        // ENEMIES

        // TODO: new Enemy()
    }

    private void drawProperties() {
        // ROOT

        Container root = this.getContentPane();

        root.setBackground(Color.BLACK);
    }
}
