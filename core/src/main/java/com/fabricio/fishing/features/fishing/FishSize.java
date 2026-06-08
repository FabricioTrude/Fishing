package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.math.MathUtils;

public enum FishSize {

    MINUSCULE (0.4f),
    TINY      (0.60f),
    SMALL     (0.80f),
    AVERAGE   (0.95f),
    NORMAL    (1.00f),
    BIG       (1.25f),
    VERY_BIG  (1.70f),
    GIGANTIC  (2.20f),
    COLOSSAL  (3.50f);

    private final float scale;

    FishSize(float scale) {
        this.scale = scale;
    }

    public float getScale() {
        return scale;
    }

    public static FishSize random(){
        float roll = MathUtils.random(100f);

        if (roll < 40f) return NORMAL;
        if (roll < 60f) return AVERAGE;
        if (roll < 75f) return SMALL;
        if (roll < 85f) return BIG;
        if (roll < 90f) return TINY;
        if (roll < 95f) return VERY_BIG;
        if (roll < 98f) return MINUSCULE;
        if (roll < 99.5f) return GIGANTIC;

        return COLOSSAL;
    }
}
