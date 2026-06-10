package com.fabricio.fishing.assets;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.event.records.FishClickedEvent;

import static com.fabricio.fishing.features.GameContext.*;

public class SoundManager {

    private final Sound fishCaught;

    public SoundManager(GameAssets gameAssets){
        fishCaught = gameAssets.getSound(Sounds.FISH_CLICKED);
        eventBus.register(FishClickedEvent.class, this::FishCaughtSound);
    }

    public void FishCaughtSound(FishClickedEvent e){
        long id = fishCaught.play();
        fishCaught.setPitch(id, MathUtils.random(0.85f, 1.15f));
    }
}
