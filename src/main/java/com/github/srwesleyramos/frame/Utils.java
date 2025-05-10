package com.github.srwesleyramos.frame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Utils {

    public static ImageIcon getScaledIcon(String fileName, int width, int height) {
        URL iconUrl = Utils.class.getResource(fileName);

        if (iconUrl == null) {
            throw new RuntimeException(fileName + " icon not found!");
        }

        Image image = new ImageIcon(iconUrl)
                .getImage()
                .getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(image);
    }
}
