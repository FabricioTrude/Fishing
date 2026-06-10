package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.assets.FishAssets;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.entity.enums.Zones;

import java.util.EnumSet;

public enum FishSpecies {

    BASS(
        "Bass",
        Zones.SWAMP,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FishAssets.BassTexture
    ),
    SALMON(
        "Salmon",
        Zones.SWAMP,
        EnumSet.of(TimePeriod.DAWN, TimePeriod.DAY, TimePeriod.SUNSET),
        3.5f,
        0.2f,
        2f,
        25,
        1.5f,
        15,
        FishAssets.SalmonTexture
    ),
    COD(
        "Cod",
        Zones.SWAMP,
        EnumSet.of(TimePeriod.DAWN, TimePeriod.DAY, TimePeriod.SUNSET),
        2,
        1,
        1,
        20,
        1.5f,
        5,
        FishAssets.CodTexture
    ),
    CLOWN_FISH(
        "Clown Fish",
        Zones.SWAMP,
        EnumSet.of(TimePeriod.DAWN, TimePeriod.DAY, TimePeriod.SUNSET),
        5,
        0,
        2,
        30,
        1.5f,
        20,
        FishAssets.ClownFishTexture
    );

    final String name;
    final Zones zone;
    final EnumSet<TimePeriod> periods;
    final float baseHP;
    final float baseDEF;
    final float baseVAL;
    final float baseSPE;
    final float baseSIZ;
    final float baseSTAM;
    final Texture texture;

    FishSpecies(String name, Zones zone, EnumSet<TimePeriod> periods, float baseHP, float baseDEF, float baseVAL, float baseSPE, float baseSIZ, float baseSTAM, Texture texture) {
        this.name = name;
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

    public String getName() {
        return name;
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

    public static FishSpecies fromName(String name){
        return FishSpecies.valueOf(name);
    }
}
