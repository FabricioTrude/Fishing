package com.fabricio.fishing.ui.screens.features;

import com.fabricio.fishing.features.fishing.records.FishCaughtEvent;
import com.fabricio.fishing.features.fishing.enums.FishSpecies;
import com.fabricio.fishing.save.records.LoadGameEvent;
import com.fabricio.fishing.ui.screens.entries.FishEntry;
import com.fabricio.fishing.ui.generics.MediumSizePanel;

import java.util.EnumMap;

import static com.fabricio.fishing.features.GameContext.*;

public class FishBackpackHud extends MediumSizePanel {

    final EnumMap<FishSpecies, FishEntry> entries = new EnumMap<>(FishSpecies.class);

    public FishBackpackHud() {
        super("BackPack");
        createEntries();
        setVisible(false);
        eventBus.register(LoadGameEvent.class, e -> updateEntries());
        eventBus.register(FishCaughtEvent.class, e -> updateFish(e.fish().getSpecies()));
    }

    private void createEntries(){
        float x = 20;
        float y = height - 80;
        for(FishSpecies fish: FishSpecies.values()){
            System.out.println(fish.getName());
            FishEntry entry = new FishEntry(fish);
            entry.setPosition(x,y);
            entries.put(fish,entry);
            addActor(entry);
            y-=40;
        }
    }

    public void updateFish(FishSpecies fish){
        FishEntry entry = entries.get(fish);
        entry.setCount(
            Math.round(inventoryManager.getFish(fish))
        );
    }

    public void updateEntries(){
        for(FishSpecies fish : FishSpecies.values()){
            updateFish(fish);
        }
    }
}
