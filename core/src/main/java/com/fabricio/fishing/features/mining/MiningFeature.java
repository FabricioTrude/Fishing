package com.fabricio.fishing.features.mining;

import com.fabricio.fishing.data.PlayerData;

public class MiningFeature {
    public void update(float delta){
        PlayerData.player.update(delta);
    }
}
