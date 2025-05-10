package com.github.srwesleyramos.frame;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        this.setTitle("SPACE INVADERS");
        this.setSize(500, 500);
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

        // TODO: new Player()

        // ENEMIES

        // TODO: new Enemy()
    }

    private void drawProperties() {
        // ROOT

        Container root = this.getContentPane();

        root.setBackground(Color.BLACK);
    }
}
