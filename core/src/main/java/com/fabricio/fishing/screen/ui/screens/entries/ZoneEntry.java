package com.fabricio.fishing.screen.ui.screens.entries;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.features.fishing.enums.FishingZones;
import com.fabricio.fishing.features.fishing.records.FishingZoneSwitchEvent;
import com.fabricio.fishing.screen.ui.actors.ColorActor;

import static com.fabricio.fishing.features.GameContext.*;

public class ZoneEntry extends Group {
    private static float WIDTH = 368;
    private static float HEIGHT = 72;
    private final Label name;
    private final FishingZones zone;

    public ZoneEntry(FishingZones zone) {
        this.zone = zone;
        String zoneName = zone.getName();
        setSize(WIDTH, HEIGHT);
        ColorActor bg = new ColorActor(zone.getColor());
        bg.setSize(WIDTH, HEIGHT);
        addActor(bg);
        name = new Label(zoneName, UIAssets.NORMAL);
        name.setPosition(30, (HEIGHT - name.getPrefHeight()) / 2f);
        addActor(name);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                eventBus.post(new FishingZoneSwitchEvent(zone));
            }
        });
    }
}
