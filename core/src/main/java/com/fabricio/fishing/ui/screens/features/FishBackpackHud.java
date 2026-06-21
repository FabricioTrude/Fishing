package com.fabricio.fishing.ui.screens.features;

import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.features.fishing.enums.FishSpecies;
import com.fabricio.fishing.features.fishing.records.FishCaughtEvent;
import com.fabricio.fishing.save.records.LoadGameEvent;
import com.fabricio.fishing.ui.generics.MediumSizePanel;
import com.fabricio.fishing.ui.screens.entries.FishEntry;

import java.util.EnumMap;

public class FishBackpackHud extends MediumSizePanel {

    final EnumMap<FishSpecies, FishEntry> entries = new EnumMap<>(FishSpecies.class);

    public FishBackpackHud() {
        super("BackPack");
        createEntries();
        setVisible(false);
        G.ebus().register(LoadGameEvent.class, e -> updateEntries());
        G.ebus().register(FishCaughtEvent.class, e -> updateFish(e.fish().getSpecies()));
    }

    private void createEntries(){
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
            Math.round(G.inventory().getFish(fish))
        );
    }

    public void updateEntries(){
        for(FishSpecies fish : FishSpecies.values()){
            updateFish(fish);
        }
    }
}
