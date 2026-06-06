package com.fabricio.fishing.entity.fish;

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
