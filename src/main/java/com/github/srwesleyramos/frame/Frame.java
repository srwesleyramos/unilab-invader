package com.github.srwesleyramos.frame;

import com.github.srwesleyramos.entities.Enemy;
import com.github.srwesleyramos.entities.Player;
import com.github.srwesleyramos.enums.EnemyType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/*
 * TODO: adicionar vida ao jogador e inimigos;
 * TODO: adicionar score ao destruir inimigo;
 *
 * TODO: adicionar movimentação ao jogador;
 * TODO: adicionar disparos contra os inimigos;
 * TODO: adicionar movimentação aos inimigos;
 * TODO: adicionar disparos contra o jogador;
 */

public class Frame extends JFrame implements KeyListener {

    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 500;

    public Player player;
    public List<Enemy> enemies;

    public Frame() {
        this.setTitle("SPACE INVADERS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH + 16, FRAME_HEIGHT + 40);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        this.addKeyListener(this);

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

    @Override
    public void keyTyped(KeyEvent e) {
        enemies.forEach(enemy -> enemy.handleEvent(e.getKeyChar()));
        player.handleEvent(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // ignored
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // ignored
    }
}
