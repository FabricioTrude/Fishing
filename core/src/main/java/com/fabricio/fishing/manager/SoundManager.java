package com.fabricio.fishing.manager;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.assets.GameAssets;
import com.fabricio.fishing.assets.Sounds;
import com.fabricio.fishing.event.Event;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.event.FishClickedEvent;
import com.fabricio.fishing.event.FishDiedEvent;

public class SoundManager {

    private final Sound fishCaught;

    public SoundManager(EventBus eventBus, GameAssets gameAssets){
        fishCaught = gameAssets.getSound(Sounds.FISH_CLICKED);

        eventBus.subscribe(this::handle);
    }

    public void handle(Event event){
        if(event instanceof FishClickedEvent e){
            long id = fishCaught.play();
            fishCaught.setPitch(id, MathUtils.random(0.95f,1.05f));
        }
    }
}
