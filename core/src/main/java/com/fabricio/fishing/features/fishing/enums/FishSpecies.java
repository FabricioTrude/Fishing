package com.fabricio.fishing.features.fishing.enums;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.assets.statics.FeatureAssets;
import com.fabricio.fishing.assets.statics.FishAssets;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.features.zones.Zones;

import java.util.EnumSet;

public enum FishSpecies {

    // SWAMP
    BASS(
        "bass",
        "Bass",
        Zones.SWAMP,
        7,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    CATFISH(
        "catfish",
        "Catfish",
        Zones.SWAMP,
        3,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    CICHLID(
        "cichlid",
        "Cichlid",
        Zones.SWAMP,
        5,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    PLECO(
        "pleco",
        "Pleco",
        Zones.SWAMP,
        2,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    ARMORED_CATFISH(
        "armored_catfish",
        "Armored Catfish",
        Zones.SWAMP,
        2,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    SILVER_AROWANA(
        "silver_arowana",
        "Silver Arowana",
        Zones.SWAMP,
        1,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    WOLF_FISH(
        "wolf_fish",
        "Wolf Fish",
        Zones.SWAMP,
        2,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),

    // OASIS
    GOLDFISH(
        "goldfish",
        "Goldfish",
        Zones.OASIS,
        4,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    KOI(
        "koi",
        "Koi",
        Zones.OASIS,
    2.5f,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    Tilapia(
        "tilapia",
        "Tilapia",
        Zones.OASIS,
        4,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    CHERRY_BARB(
        "cherry_barb",
        "Cherry Barb",
        Zones.OASIS,
        1,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    GOLDEN_BARB(
        "golden_barb",
        "Golden Barb",
        Zones.OASIS,
        3,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    PURPLE_CICHLID(
        "purple_cichlid",
        "Purple Cichlid",
        Zones.OASIS,
        1.5f,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    ),
    SILVER_CARP(
        "silver_carp",
        "Silver Carp",
        Zones.OASIS,
        2.5f,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10
    );

    final String id;
    final String name;
    final Zones zone;
    final float weight;
    final EnumSet<TimePeriod> periods;
    final float baseHP;
    final float baseDEF;
    final float baseVAL;
    final float baseSPE;
    final float baseSIZ;
    final float baseSTAM;

    FishSpecies(String id, String name, Zones zone, float weight, EnumSet<TimePeriod> periods, float baseHP, float baseDEF, float baseVAL, float baseSPE, float baseSIZ, float baseSTAM) {
        this.id = id;
        this.name = name;
        this.zone = zone;
        this.weight = weight;
        this.periods = periods;
        this.baseHP = baseHP;
        this.baseDEF = baseDEF;
        this.baseVAL = baseVAL;
        this.baseSPE = baseSPE;
        this.baseSIZ = baseSIZ;
        this.baseSTAM = baseSTAM;
    }

    public static FishSpecies random(Zones zone){
        float totalWeight = 0;
        for (FishSpecies fish : values()) if(fish.zone == zone) totalWeight += fish.weight;
        float roll = MathUtils.random(totalWeight), accumulated = 0;
        for (FishSpecies fish : values()){
            if (fish.zone != zone) continue;
            accumulated += fish.weight;
            if(roll < accumulated) return fish;
        }
        return null;

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

    public TextureRegion getTexture() {
        return FishAssets.get(zone.getId(), id);
    }

    public static FishSpecies fromName(String name){
        return FishSpecies.valueOf(name);
    }
}

//SALMON(
//        "Salmon",
//            null,
//            0,
//        EnumSet.of(TimePeriod.DAWN, TimePeriod.DAY, TimePeriod.SUNSET),
//        3.5f,
//            0.2f,
//            2f,
//            25,
//            1.5f,
//            15,
//FeatureAssets.SalmonTexture
//    ),
//COD(
//        "Cod",
//            null,
//            0,
//        EnumSet.of(TimePeriod.DAWN, TimePeriod.DAY, TimePeriod.SUNSET),
//        2,
//            1,
//            1,
//            20,
//            1.5f,
//            5,
//FeatureAssets.CodTexture
//    ),
//CLOWN_FISH(
//        "Clown Fish",
//            null,
//            0,
//        EnumSet.of(TimePeriod.DAWN, TimePeriod.DAY, TimePeriod.SUNSET),
//        5,
//            0,
//            2,
//            30,
//            1.5f,
//            20,
//FeatureAssets.ClownFishTexture
//    );
