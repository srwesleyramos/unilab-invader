package com.github.srwesleyramos.base;

import com.github.srwesleyramos.frame.Frame;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public abstract class BaseThread implements ActionListener {

    private final Frame frame;
    private final Timer timer;

    public BaseThread(Frame frame, int delay) {
        this.frame = frame;
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
