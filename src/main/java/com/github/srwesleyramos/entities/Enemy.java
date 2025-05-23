package com.github.srwesleyramos.entities;

import com.github.srwesleyramos.base.BaseEntity;
import com.github.srwesleyramos.enums.EnemyType;
import com.github.srwesleyramos.layout.GameLayout;
import com.github.srwesleyramos.Utils;
import lombok.Getter;

@Getter
public class Enemy extends BaseEntity {

    public static final int ENEMY_WIDTH = 20;
    public static final int ENEMY_HEIGHT = 16;
    public static final int ENEMY_OFFSET = 55;
    public static final int ENEMY_SPEED = 2;

    private final int column, row;
    private final EnemyType type;

    public Enemy(GameLayout game, int row, int column, EnemyType type) {
        super(game, ENEMY_WIDTH, ENEMY_HEIGHT);

        this.column = column;
        this.row = row;
        this.type = type;

        this.create(
                90 + (ENEMY_WIDTH * (column - 1)) + (10 * (column - 1)),
                60 + (ENEMY_HEIGHT * (row - 1)) + (10 * (row - 1))
        );
    }

    @Override
    public void applySprite() {
        this.setIcon(Utils.getScaledIcon(this.getType().getStandUrl(), this.getWidth(), this.getHeight()));
    }

    @Override
    public void handleEvent(BaseEntity entity) {
        // TODO: adicionar animação de morte

        getGame().remove(this);
        getGame().getEnemies().remove(this);
    }
}
