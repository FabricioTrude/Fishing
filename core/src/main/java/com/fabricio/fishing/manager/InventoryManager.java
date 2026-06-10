package com.fabricio.fishing.manager;

import com.fabricio.fishing.event.records.FishCaughtEvent;
import com.fabricio.fishing.features.fishing.FishSpecies;

import java.util.EnumMap;

import static com.fabricio.fishing.features.GameContext.*;

public class InventoryManager {

    private final EnumMap<FishSpecies, Float> fishes = new EnumMap<>(FishSpecies.class);

    public InventoryManager(){
        for(FishSpecies fish: FishSpecies.values()){
            fishes.put(fish, 0f);
        }

        eventBus.register(FishCaughtEvent.class, event -> addFish(event.fish().getSpecies(), event.amount()));
    }

    public void addFish(FishSpecies fish, float number){
        fishes.put(fish, fishes.get(fish) + number);
        System.out.println(fish.getName()+": "+fishes.get(fish));
    }

    public float getFishes(FishSpecies fish) {
        return fishes.getOrDefault(fish,0f);
    }

}
