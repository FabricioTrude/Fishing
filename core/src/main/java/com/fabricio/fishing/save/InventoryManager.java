package com.fabricio.fishing.save;

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
    }

    public float getFish(FishSpecies fish) {
        return fishes.getOrDefault(fish,0f);
    }

    public EnumMap<FishSpecies, Float> getFishes(){
        return new EnumMap<>(fishes);
    }

    public void save(SaveData save){
        save.fishes.clear();
        for(var entry : fishes.entrySet()){
            save.fishes.put(
                entry.getKey().name(),
                entry.getValue()
            );
        }
    }

    public void load(SaveData save){
        if(save.fishes!=null) {
            this.fishes.clear();
            for(var entry : save.fishes.entrySet()){
                fishes.put(
                    FishSpecies.valueOf(entry.getKey()),
                    entry.getValue()
                );
            }
        }
    }
}
