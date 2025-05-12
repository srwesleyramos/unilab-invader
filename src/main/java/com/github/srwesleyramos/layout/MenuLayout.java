package com.github.srwesleyramos.layout;

import com.github.srwesleyramos.Utils;

import javax.swing.*;
import java.awt.*;

public class MenuLayout extends JFrame {

    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 500;

    public MenuLayout() {
        this.setSize(FRAME_WIDTH + 16, FRAME_HEIGHT + 40);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.drawLayout();
        this.drawButtons();

        this.setVisible(true);
    }

    private void drawLayout() {
        Container root = this.getContentPane();
        root.setBackground(Color.BLACK);
    }

    private void drawButtons() {
        JLabel spaceLabel = new JLabel();

        spaceLabel.setSize(250, 112);
        spaceLabel.setLocation((getWidth() / 2) - (spaceLabel.getWidth() / 2), 135);
        spaceLabel.setIcon(Utils.getScaledIcon("/assets/space.png", spaceLabel.getWidth(), spaceLabel.getHeight()));

        JButton playButton = createButton("JOGAR", spaceLabel.getY() + spaceLabel.getHeight(), 50);

        playButton.addActionListener((e) -> {
            System.out.println(e);
        });

        JButton quitButton = createButton("SAIR", playButton.getY() + playButton.getHeight(), 8);

        quitButton.addActionListener((e) -> {
            System.exit(0);
        });

        this.add(spaceLabel);
        this.add(playButton);
        this.add(quitButton);
    }

    private JButton createButton(String label, int height, int gap) {
        JButton button = new JButton(label);

        button.setBackground(Color.decode("#ffe200"));
        button.setForeground(Color.BLACK);
        button.setBorder(null);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setSize(150, 30);
        button.setLocation((getWidth() / 2) - (button.getWidth() / 2), height + gap);

        return button;
    }
}
