package com.github.srwesleyramos.base;

import com.github.srwesleyramos.layout.GameLayout;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public abstract class BaseThread implements ActionListener {

    private final GameLayout game;
    private final Timer timer;

    public BaseThread(GameLayout game, int delay) {
        this.game = game;
        this.timer = new Timer(delay, this);
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            this.run();
        }
    }

    public abstract void run();
}
