package com.fabricio.fishing.screen.ui.features;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.fabricio.fishing.assets.UIAssets;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.features.fishing.FishSpecies;
import com.fabricio.fishing.features.fishing.FishingFeature;
import com.fabricio.fishing.screen.ui.actors.TextureActor;
import com.fabricio.fishing.screen.ui.entries.FishEntry;

import java.util.EnumMap;

import static com.fabricio.fishing.features.GameContext.*;

public class FishBackpack extends Group {
    float width = 400;
    float height = 500;

    final EnumMap<FishSpecies, FishEntry> entries = new EnumMap<>(FishSpecies.class);

    public FishBackpack() {
        setBounds((SCREEN_WIDTH-width) / 2f, (SCREEN_HEIGHT-height) / 2f, width, height);
        createBackground();
        createFishEntries();
        setVisible(false);
    }
    public void toggle(){
        setVisible(!isVisible());
    }

    private void createBackground(){
        TextureActor background = new TextureActor(UIAssets.FishingInventory);
        background.setBounds(0,0,width,height);
        addActor(background);
    }
    private void createTitle(){

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
        FishingFeature fishing = GameContext.getContext().getFishingFeature();
        if(fishing != null){
            entry.setCount(
                Math.round(fishing.getFishes(fish))
            );
        }
    }
}
