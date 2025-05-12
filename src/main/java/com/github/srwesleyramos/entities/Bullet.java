package com.github.srwesleyramos.entities;

import com.github.srwesleyramos.base.BaseEntity;
import com.github.srwesleyramos.frame.Frame;
import lombok.Getter;

import java.awt.*;

@Getter
public class Bullet extends BaseEntity {

    public static final int BULLET_WIDTH = 2;
    public static final int BULLET_HEIGHT = 2;
    public static final int BULLET_SPEED = 5;

    private final BaseEntity entity;
    private final int direction;

    public Bullet(Frame frame, BaseEntity entity) {
        super(frame, BULLET_WIDTH, BULLET_HEIGHT);

        this.entity = entity;
        this.direction = entity instanceof Player ? -1 : +1;

        this.create(
                entity.getX() + (entity.getWidth() / 2) - (BULLET_WIDTH / 2),
                entity.getY() + (entity.getHeight() * direction) + (BULLET_HEIGHT * direction)
        );
    }

    @Override
    public void applySprite() {
        this.setBackground(entity instanceof Player ? Color.YELLOW : Color.WHITE);
        this.setOpaque(true);
    }

    @Override
    public void handleEvent(BaseEntity entity) {
        if (entity instanceof Bullet || entity == null) {
            // TODO: adicionar animação de explosão

            System.out.println("bullet was destroyed!");
        }

        getFrame().remove(this);
        getFrame().getBullets().remove(this);
    }
}
