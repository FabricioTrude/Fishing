package com.fabricio.fishing.features.fishing.enums;

public enum FishRarity {
    COMMON,
    UNCOMMON,
    RARE,
    VERY_RARE,
    EPIC,
    SUPER_EPIC,
    LEGENDARY,
    MYTHIC;

    public static FishRarity random(){
        return COMMON;
    }
}
