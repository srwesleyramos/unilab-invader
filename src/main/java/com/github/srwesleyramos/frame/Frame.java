package com.github.srwesleyramos.frame;

import com.github.srwesleyramos.entities.Enemy;
import com.github.srwesleyramos.entities.Player;
import com.github.srwesleyramos.enums.EnemyType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame {

    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 500;

    public Player player;
    public List<Enemy> enemies;

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

        this.player = new Player(this);

        // ENEMIES

        this.enemies = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            EnemyType type = i != 1 ? (i == 2 || i == 3 ? EnemyType.RED : EnemyType.YELLOW) : EnemyType.GREEN;

            for (int j = 1; j <= 11; j++) {
                this.enemies.add(new Enemy(this, i, j, type));
            }
        }
    }

    private void drawProperties() {
        // ROOT

        Container root = this.getContentPane();

        root.setBackground(Color.BLACK);
    }
}
