package com.fabricio.fishing.features.fishing.enums;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.assets.AnimatedAsset;
import com.fabricio.fishing.assets.FeatureType;
import com.fabricio.fishing.assets.enums.AtlasId;
import com.fabricio.fishing.assets.statics.FeatureAssets;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.features.Feature;
import com.fabricio.fishing.features.zones.Zones;

import java.util.EnumSet;
import java.util.Locale;

public enum FishSpecies implements FeatureType {

    // SWAMP
    BASS(
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

    FishSpecies(String name, Zones zone, float weight, EnumSet<TimePeriod> periods, float baseHP, float baseDEF, float baseVAL, float baseSPE, float baseSIZ, float baseSTAM) {
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

    public String display() {
        return name;
    }
    public EnumSet<TimePeriod> periods() {
        return periods;
    }
    public float HP() {
        return baseHP;
    }
    public float DEF() {
        return baseDEF;
    }
    public float VAL() {
        return baseVAL;
    }
    public float SPE() {
        return baseSPE;
    }
    public float SIZ() {
        return baseSIZ;
    }
    public float STAM() {
        return baseSTAM;
    }

    public static FishSpecies fromName(String name){
        return FishSpecies.valueOf(name);
    }

    @Override
    public Zones zone() {
        return zone;
    }
    @Override
    public String id() {
        return name().toLowerCase(Locale.ROOT);
    }

    @Override
    public AtlasId atlas() {
        return zone.atlas(Feature.FISHING);
    }

    @Override
    public AnimatedAsset texture() {
        return FeatureType.super.texture();
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
