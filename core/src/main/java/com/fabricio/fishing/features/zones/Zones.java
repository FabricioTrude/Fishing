package com.fabricio.fishing.features.zones;

import com.badlogic.gdx.graphics.Color;
import com.fabricio.fishing.entity.enums.Palette;

import static com.fabricio.fishing.features.GameContext.SCREEN_HEIGHT;

public enum Zones {
    SWAMP(
        "Swamp",
        Palette.SWAMP_POND,
        0.55f * SCREEN_HEIGHT
    ),
    OASIS(
        "Oasis",
        Palette.OASIS_POND,
        0.6f * SCREEN_HEIGHT
    ),
    VOLCANO(
        "Volcano",
        Color.YELLOW,
        0.7f * SCREEN_HEIGHT
    ),
    ZONE_4(
        "Zone 4",
        Color.GREEN,
        0.5f * SCREEN_HEIGHT
    );

    final String name;
    final Color color;
    final float sea_height;

    Zones(String name, Color color, float sea_height) {
        this.name = name;
        this.color = color;
        this.sea_height = sea_height;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public float getSea_height() {
        return sea_height;
    }
}
