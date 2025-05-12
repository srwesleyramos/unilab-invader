package com.github.srwesleyramos.frame;

import com.github.srwesleyramos.base.BaseThread;
import com.github.srwesleyramos.entities.Bullet;
import com.github.srwesleyramos.entities.Enemy;
import com.github.srwesleyramos.entities.Player;
import com.github.srwesleyramos.enums.EnemyType;
import com.github.srwesleyramos.threads.KeyboardThread;
import com.github.srwesleyramos.threads.MovementThread;
import com.github.srwesleyramos.threads.ProjectileThread;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Frame extends JFrame {

    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 500;

    public List<Bullet> bullets;
    public List<Enemy> enemies;
    public List<BaseThread> threads;

    public Player player;

    public Frame() {
        this.setSize(FRAME_WIDTH + 16, FRAME_HEIGHT + 40);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        this.spawnEntities();
        this.drawLayout();
        this.startThreads();

        this.addKeyListener(new KeyboardThread(this));
    }

    private void drawLayout() {
        // ROOT

        Container root = this.getContentPane();

        root.setBackground(Color.BLACK);
    }

    private void startThreads() {
        // THREADS

        this.threads = new ArrayList<>();
        this.threads.add(new MovementThread(this));
        this.threads.add(new ProjectileThread(this));
    }

    private void spawnEntities() {
        // BULLETS

        this.bullets = new ArrayList<>();

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
}
