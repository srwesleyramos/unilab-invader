package com.github.srwesleyramos.frame;

import com.github.srwesleyramos.base.BaseEntity;
import com.github.srwesleyramos.entities.Bullet;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.List;

public class Utils {

    public static void checkCollisions(Bullet bullet, List<BaseEntity> entities) {
        entities.stream()
                .filter(entity -> entity != bullet)
                .filter(entity -> entity.getBounds().intersects(bullet.getBounds()))
                .forEach(entity -> {
                    bullet.handleEvent(entity);
                    entity.handleEvent(bullet);
                });
    }

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
