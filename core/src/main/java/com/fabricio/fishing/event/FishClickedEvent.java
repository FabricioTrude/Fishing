package com.fabricio.fishing.event;

import com.fabricio.fishing.features.fishing.Fish;

public class FishClickedEvent implements Event{
    public final Fish targetFish;

    public FishClickedEvent(Fish fish){
        this.targetFish = fish;
    }
}
