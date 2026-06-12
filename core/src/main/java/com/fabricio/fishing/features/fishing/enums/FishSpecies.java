package com.fabricio.fishing.features.fishing.enums;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.assets.statics.FeatureAssets;
import com.fabricio.fishing.entity.enums.TimePeriod;

import java.util.EnumSet;

public enum FishSpecies {

    // SWAMP
    BASS(
        "Bass",
        FishingZones.SWAMP,
        7,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.BassTexture
    ),
    CATFISH(
        "Catfish",
        FishingZones.SWAMP,
        3,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.CatfishTexture
    ),
    CICHLID(
        "Cichlid",
        FishingZones.SWAMP,
        5,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.CichlidTexture
    ),
    PLECO(
        "Pleco",
        FishingZones.SWAMP,
        2,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.PlecoTexture
    ),
    ARMORED_CATFISH(
        "Armored Catfish",
        FishingZones.SWAMP,
        2,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.ArmoredCatfishTexture
    ),
    SILVER_AROWANA(
        "Silver Arowana",
        FishingZones.SWAMP,
        1,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.SilverArowanaTexture
    ),
    WOLF_FISH(
        "Wolf Fish",
        FishingZones.SWAMP,
        2,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.WolfFishTexture
    ),

    // OASIS
    GOLDFISH(
        "Goldfish",
        FishingZones.OASIS,
        4,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.GoldfishTexture
    ),
    KOI(
        "Koi",
        FishingZones.OASIS,
    2.5f,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.KoiTexture
    ),
    Tilapia(
        "Tilapia",
        FishingZones.OASIS,
        4,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.TilapiaTexture
    ),
    CHERRY_BARB(
        "Cherry Barb",
        FishingZones.OASIS,
        1,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.CherryBarbTexture
    ),
    GOLDEN_BARB(
        "Golden Barb",
        FishingZones.OASIS,
        3,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.GoldenBarbTexture
    ),
    PURPLE_CICHLID(
        "Purple Cichlid",
        FishingZones.OASIS,
        1.5f,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.PurpleCichlidTexture
    ),
    SILVER_CARP(
        "Silver Carp",
        FishingZones.OASIS,
        2.5f,
        EnumSet.allOf(TimePeriod.class),
        2,
        0,
        1,
        30,
        1.5f,
        10,
        FeatureAssets.SilverCarpTexture
    );

    final String name;
    final FishingZones zone;
    final float weight;
    final EnumSet<TimePeriod> periods;
    final float baseHP;
    final float baseDEF;
    final float baseVAL;
    final float baseSPE;
    final float baseSIZ;
    final float baseSTAM;
    final Texture texture;

    FishSpecies(String name, FishingZones zone, float weight, EnumSet<TimePeriod> periods, float baseHP, float baseDEF, float baseVAL, float baseSPE, float baseSIZ, float baseSTAM, Texture texture) {
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
        this.texture = texture;
    }

    public static FishSpecies random(FishingZones zone){
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

    public FishingZones getZone() {
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
