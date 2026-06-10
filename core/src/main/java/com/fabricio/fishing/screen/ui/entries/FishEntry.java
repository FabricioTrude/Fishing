package com.fabricio.fishing.screen.ui.entries;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.fabricio.fishing.assets.UIAssets;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.features.fishing.FishSpecies;
import com.fabricio.fishing.save.InventoryManager;
import com.fabricio.fishing.screen.ui.actors.TextureActor;
import static com.fabricio.fishing.assets.UIAssets.*;

public class FishEntry extends Group {
    private static final float WIDTH = 360;
    private static final float HEIGHT = 32;

    private final Label counter;
    private final FishSpecies fish;

    public FishEntry(FishSpecies fish) {
        this.fish = fish;
        int amount = 0;
        InventoryManager inventoryManager = GameContext.getContext().getInventoryManager();
        amount = Math.round(inventoryManager.getFish(fish));
        TextureActor wallpaper = new TextureActor(UIAssets.wood);
        setSize(WIDTH,HEIGHT);
        wallpaper.setBounds(0,0,WIDTH,HEIGHT);
        addActor(wallpaper);
        TextureActor icon = new TextureActor(fish.getTexture());
        icon.setBounds(0,0,48,32);
        addActor(icon);

        Label label = new Label(fish.getName(), NORMAL);
        label.setPosition(56, (HEIGHT - label.getPrefHeight()) / 2f);
        addActor(label);

        counter = new Label(String.valueOf(amount), NORMAL);
        counter.setPosition(WIDTH - 50,(HEIGHT - counter.getPrefHeight()) / 2f);
        addActor(counter);
    }

    public void setCount(int amount) {
            counter.setText(Integer.toString(amount));
    }
}
