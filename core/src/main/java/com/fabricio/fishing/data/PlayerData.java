package com.fabricio.fishing.data;

import com.fabricio.fishing.features.player.PlayerEntity;

public class PlayerData {
    public static PlayerEntity player = null;
    public static final FishingData fishingData = new FishingData();

    public static void setPlayer(PlayerEntity player) {
        PlayerData.player = player;
    }

    public static PlayerEntity getPlayer() {
        return player;
    }
}
