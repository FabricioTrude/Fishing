package com.fabricio.fishing.features.zones;

import com.badlogic.gdx.graphics.Color;
import com.fabricio.fishing.assets.enums.AtlasId;
import com.fabricio.fishing.entity.enums.Palette;
import com.fabricio.fishing.features.Feature;

import java.util.Locale;
import java.util.Map;

import static com.fabricio.fishing.context.GlobalContext.*;

public enum Zones {
    SWAMP(
        "Swamp",
        Palette.SWAMP_POND,
        0.55f * SCREEN_HEIGHT,
        Map.of(Feature.FISHING, AtlasId.FISHING_SWAMP,
            Feature.MINING, AtlasId.MINING_SWAMP)
    ),
    OASIS(
        "Oasis",
        Palette.OASIS_POND,
        0.6f * SCREEN_HEIGHT,
        Map.of(Feature.FISHING, AtlasId.FISHING_OASIS)
    ),
    VOLCANO(
        "Volcano",
        Color.YELLOW,
        0.7f * SCREEN_HEIGHT,
        null
    ),
    ZONE_4(
        "Zone 4",
        Color.GREEN,
        0.5f * SCREEN_HEIGHT,
        null
    );

    final String name;
    final Color color;
    final float sea_height;
    final Map<Feature, AtlasId> atlases;

    Zones(String name, Color color, float sea_height, Map<Feature, AtlasId> atlases) {
        this.name = name;
        this.color = color;
        this.sea_height = sea_height;
        this.atlases = atlases;
    }

    public String display() {
        return name;
    }
    public Color color() {
        return color;
    }
    public String id() {return name().toLowerCase(Locale.ROOT);}
    public float getSea_height() {
        return sea_height;
    }
    public AtlasId atlas(Feature feature){
        AtlasId atlas = atlases.get(feature);
        if (atlas == null)
            throw new IllegalArgumentException(
                "Zona %s não possui atlas para %s"
                    .formatted(this, feature));
        return atlas;
    }
}
