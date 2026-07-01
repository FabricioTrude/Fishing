package com.fabricio.fishing.ui.screens.entries;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.features.fishing.enums.FishSpecies;
import com.fabricio.fishing.ui.actors.TextureActor;

import static com.fabricio.fishing.assets.statics.UIAssets.*;

public class FishEntry extends Group {
    private static final float WIDTH = 360;
    private static final float HEIGHT = 32;

    private final Label counter;
    private final FishSpecies fish;

    public FishEntry(FishSpecies fish) {
        this.fish = fish;
        int amount = 0;
        amount = Math.round(G.inventory().getFish(fish));
        TextureActor wallpaper = new TextureActor(UIAssets.wood);
        setSize(WIDTH,HEIGHT);
        wallpaper.setBounds(0,0,WIDTH,HEIGHT);
        addActor(wallpaper);
        TextureActor icon = new TextureActor(fish.texture().defaultFrame());
        icon.setBounds(0,0,48,32);
        addActor(icon);

        Label label = new Label(fish.display(), NORMAL);
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
