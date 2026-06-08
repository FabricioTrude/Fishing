package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.entity.enums.Zones;

import java.util.EnumSet;

public enum FishSpecies {

    BASS(
        Zones.SWAMP,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        new Texture("fishes/bass.png")
    ),
    SALMON(
        Zones.SWAMP,
        EnumSet.of(TimePeriod.DAWN, TimePeriod.DAY, TimePeriod.SUNSET),
        3.5f,
        0.2f,
        2f,
        25,
        1.5f,
        15,
        new Texture("fishes/salmon.png")
    ),
    COD(
        Zones.SWAMP,
        EnumSet.of(TimePeriod.DAWN, TimePeriod.DAY, TimePeriod.SUNSET),
        2,
        1,
        1,
        20,
        1.5f,
        5,
        new Texture("fishes/cod.png")
    ),
    CLOWN_FISH(
        Zones.SWAMP,
        EnumSet.of(TimePeriod.DAWN, TimePeriod.DAY, TimePeriod.SUNSET),
        5,
        0,
        2,
        30,
        1.5f,
        20,
        new Texture("fishes/clown_fish.png")
    );

    protected final Zones zone;
    protected final EnumSet<TimePeriod> periods;
    protected final float baseHP;
    protected final float baseDEF;
    protected final float baseVAL;
    protected final float baseSPE;
    protected final float baseSIZ;
    protected final float baseSTAM;
    protected final Texture texture;

    FishSpecies(Zones zone, EnumSet<TimePeriod> periods, float baseHP, float baseDEF, float baseVAL, float baseSPE, float baseSIZ, float baseSTAM, Texture texture) {
        this.zone = zone;
        this.periods = periods;
        this.baseHP = baseHP;
        this.baseDEF = baseDEF;
        this.baseVAL = baseVAL;
        this.baseSPE = baseSPE;
        this.baseSIZ = baseSIZ;
        this.baseSTAM = baseSTAM;
        this.texture = texture;
    }
    public static FishSpecies random(Zones zone){
        float roll = MathUtils.random(100f);
        FishSpecies species = switch(zone){
            case SWAMP -> {
                if (roll < 30f) yield BASS;
                if (roll < 55.5f) yield SALMON;
                if (roll < 75f) yield CLOWN_FISH;
                yield COD;
            }
            default -> BASS;
        };
        return species;
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

    public float getBaseSTAM() {
        return baseSTAM;
    }

    public Texture getTexture() {
        return texture;
    }
}
