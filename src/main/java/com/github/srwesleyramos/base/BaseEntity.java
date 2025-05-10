package com.github.srwesleyramos.base;

import com.github.srwesleyramos.frame.Frame;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class BaseEntity extends JLabel {

    private final Frame frame;
    private final int width, height;

    private int x0, y0;

    public BaseEntity(Frame frame, int width, int height) {
        this.frame = frame;
        this.width = width;
        this.height = height;
    }

    public void spawn(int x0, int y0) {
        this.x0 = x0;
        this.y0 = y0;

        this.setBounds(x0, y0, width, height);
        this.applySprite();
        this.frame.add(this);
    }

    public void applySprite() {
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setOpaque(true);
    }

    public void handleEvent(char keyChar) {
        // not implemented yet
    }
}
