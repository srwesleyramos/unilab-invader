package com.github.srwesleyramos.entities;

import com.github.srwesleyramos.base.BaseEntity;
import com.github.srwesleyramos.enums.EnemyType;
import com.github.srwesleyramos.frame.Frame;
import com.github.srwesleyramos.frame.Utils;
import lombok.Getter;

@Getter
public class Enemy extends BaseEntity {

    public static final int ENEMY_WIDTH = 20;
    public static final int ENEMY_HEIGHT = 16;

    private final int row, column;
    private final EnemyType type;

    public Enemy(Frame frame, int column, int row, EnemyType type) {
        super(frame, ENEMY_WIDTH, ENEMY_HEIGHT);

        this.row = row;
        this.column = column;
        this.type = type;

        this.spawn(
                82 + (ENEMY_WIDTH * (row - 1)) + (10 * (row - 1)),
                60 + (ENEMY_HEIGHT * (column - 1)) + (10 * (column - 1))
        );
    }

    @Override
    public void applySprite() {
        this.setIcon(Utils.getScaledIcon("/enemy_" + this.type.name().toLowerCase() + ".png", this.getWidth(), this.getHeight()));
    }
}
