package com.github.srwesleyramos.threads;

import com.github.srwesleyramos.frame.Frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardThread implements KeyListener {

    private final Frame frame;

    public KeyboardThread(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.frame.getEnemies().forEach(
                enemy -> enemy.handleEvent(e.getKeyChar())
        );
        this.frame.getPlayer().handleEvent(e.getKeyChar());
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
