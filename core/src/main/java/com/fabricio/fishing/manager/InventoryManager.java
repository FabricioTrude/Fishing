package com.fabricio.fishing.manager;

import com.fabricio.fishing.event.Event;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.event.FishDiedEvent;
import com.fabricio.fishing.event.InventoryUpdateEvent;
import com.fabricio.fishing.features.fishing.FishSpecies;

import java.util.EnumMap;

public class InventoryManager {


    private final EnumMap<FishSpecies, Float> fishes = new EnumMap<>(FishSpecies.class);
    private final EventBus eventBus;

    public InventoryManager(EventBus eventBus){
        this.eventBus = eventBus;
        for(FishSpecies fish: FishSpecies.values()){
            fishes.put(fish, 0f);
        }
    }

    public void addFish(FishSpecies fish, float number){
        fishes.put(fish, fishes.get(fish) + number);
        System.out.println(fish.getName()+": "+fishes.get(fish));
        eventBus.publish(new InventoryUpdateEvent());
    }

    public float getFishes(FishSpecies fish) {
        return fishes.getOrDefault(fish,0f);
    }

    public void handle(Event event){
        if(event instanceof FishDiedEvent e){
            addFish(e.fish.getSpecies(), e.fish.getFishVAL());
        }
    }
}
