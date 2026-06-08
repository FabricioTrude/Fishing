package com.fabricio.fishing.event;

import com.fabricio.fishing.entity.fish.Fish;

public class FishDiedEvent implements Event{
    public final Fish fish;

    public FishDiedEvent(Fish fish){
        this.fish = fish;
    }
}
