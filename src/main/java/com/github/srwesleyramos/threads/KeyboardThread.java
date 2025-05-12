package com.github.srwesleyramos.threads;

import com.github.srwesleyramos.layout.GameLayout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardThread implements KeyListener {

    private final GameLayout game;

    public KeyboardThread(GameLayout game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.game.getEnemies().forEach(
                enemy -> enemy.handleEvent(e.getKeyChar())
        );
        this.game.getPlayer().handleEvent(e.getKeyChar());
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
