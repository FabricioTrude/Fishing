package com.fabricio.fishing.screen.ui.features;

import com.fabricio.fishing.features.fishing.records.FishCaughtEvent;
import com.fabricio.fishing.features.fishing.enums.FishSpecies;
import com.fabricio.fishing.screen.ui.entries.FishEntry;
import com.fabricio.fishing.screen.ui.generics.MediumSizePanel;

import java.util.EnumMap;

import static com.fabricio.fishing.features.GameContext.*;

public class FishBackpackHud extends MediumSizePanel {

    final EnumMap<FishSpecies, FishEntry> entries = new EnumMap<>(FishSpecies.class);

    public FishBackpackHud() {
        super("BackPack");
        createFishEntries();
        setVisible(false);
        eventBus.register(FishCaughtEvent.class, event -> {
            updateFish(event.fish().getSpecies());
        });
    }
    private void createFishEntries(){
        float x = 20;
        float y = height - 80;
        for(FishSpecies fish: FishSpecies.values()){
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
}
