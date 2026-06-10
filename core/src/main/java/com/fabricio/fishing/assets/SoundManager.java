package com.fabricio.fishing.assets;

import com.badlogic.gdx.audio.Sound;
import com.fabricio.fishing.event.records.FishCaughtEvent;

import static com.fabricio.fishing.features.GameContext.*;

public class SoundManager {

    private final Sound fishCaught;

    public SoundManager(GameAssets gameAssets){
        fishCaught = gameAssets.getSound(Sounds.FISH_CLICKED);
        eventBus.register(FishCaughtEvent.class, event -> {

        });
    }
}
