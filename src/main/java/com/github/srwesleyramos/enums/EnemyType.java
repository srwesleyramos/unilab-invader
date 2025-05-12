package com.github.srwesleyramos.enums;

import lombok.Getter;

@Getter
public enum EnemyType {

    CRAB("/assets/crab/stand.png", "/assets/crab/walk.png", "/assets/enemy_explosion.png"),
    OCTOPUS("/assets/octopus/stand.png", "/assets/octopus/walk.png", "/assets/enemy_explosion.png"),
    SQUID("/assets/squid/stand.png", "/assets/squid/walk.png", "/assets/enemy_explosion.png");

    private final String standUrl, walkUrl, deathUrl;

    EnemyType(String standUrl, String walkUrl, String deathUrl) {
        this.standUrl = standUrl;
        this.walkUrl = walkUrl;
        this.deathUrl = deathUrl;
    }
}
