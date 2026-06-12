package com.fabricio.fishing.assets;

import com.badlogic.gdx.audio.Sound;
import com.fabricio.fishing.assets.statics.SoundAssets;
import com.fabricio.fishing.features.fishing.records.FishClickedEvent;

import static com.fabricio.fishing.features.GameContext.*;

public class SoundManager {

    private final Sound fishCaught;

    public SoundManager(GameAssets gameAssets){
        fishCaught = gameAssets.getSound(SoundAssets.FISH_CLICKED);
        eventBus.register(FishClickedEvent.class, this::FishClickedSound);
    }

    public void FishClickedSound(FishClickedEvent e){
        long id = fishCaught.play();

//        fishCaught.setPitch(id, MathUtils.random(0.55f, 2.15f));
        fishCaught.setPitch(id, 1 / e.fish().getFishSIZ());
    }
}
