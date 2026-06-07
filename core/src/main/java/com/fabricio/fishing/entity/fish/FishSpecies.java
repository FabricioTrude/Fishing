package com.fabricio.fishing.entity.fish;

import com.badlogic.gdx.graphics.Texture;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.entity.enums.Zones;

import java.util.EnumSet;

public enum FishSpecies {

    BASS(
        Zones.ZONE_1,
        EnumSet.allOf(TimePeriod.class),
        3,
        0,
        1,
        30,
        10,
        new Texture("assets/fishes/fish.png")
    ),
    SALMON(
        Zones.ZONE_1,
        EnumSet.of(TimePeriod.DAWN, TimePeriod.DAY, TimePeriod.SUNSET),
        4,
        1,
        3,
        15,
        15,
        new Texture("assets/fishes/fish.png")
    );

    protected final Zones zone;
    protected final EnumSet<TimePeriod> periods;
    protected final float baseHP;
    protected final float baseDEF;
    protected final float baseVAL;
    protected final float baseSPE;
    protected final float baseSIZ;
    protected final Texture texture;

    FishSpecies(Zones zone, EnumSet<TimePeriod> periods, float baseHP, float baseDEF, float baseVAL, float baseSPE, float baseSIZ, Texture texture) {
        this.zone = zone;
        this.periods = periods;
        this.baseHP = baseHP;
        this.baseDEF = baseDEF;
        this.baseVAL = baseVAL;
        this.baseSPE = baseSPE;
        this.baseSIZ = baseSIZ;
        this.texture = texture;
    }

    public Zones getZone() {
        return zone;
    }

    public EnumSet<TimePeriod> getPeriods() {
        return periods;
    }

    public float getBaseHP() {
        return baseHP;
    }

    public float getBaseDEF() {
        return baseDEF;
    }

    public float getBaseVAL() {
        return baseVAL;
    }

    public float getBaseSPE() {
        return baseSPE;
    }

    public float getBaseSIZ() {
        return baseSIZ;
    }

    public Texture getTexture() {
        return texture;
    }
}
