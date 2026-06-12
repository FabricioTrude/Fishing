package com.fabricio.fishing.features.fishing.enums;

import com.badlogic.gdx.graphics.Color;

public enum FishingZones {
    SWAMP(
        "Swamp",
        Color.BLUE
    ),
    ZONE_2(
        "Zone 2",
        Color.CORAL
    ),
    ZONE_3(
        "Zone 3",
        Color.YELLOW
    ),
    ZONE_4(
        "Zone 4",
        Color.GREEN
    );

    final String name;
    final Color color;

    FishingZones(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
