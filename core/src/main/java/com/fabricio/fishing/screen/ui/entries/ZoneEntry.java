package com.fabricio.fishing.screen.ui.entries;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fabricio.fishing.assets.UIAssets;
import com.fabricio.fishing.entity.enums.Zones;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.screen.ui.actors.ColorActor;

public class ZoneEntry extends Group {
    private static float WIDTH = 368;
    private static float HEIGHT = 72;
    private final Label name;
    private final Zones zone;

    public ZoneEntry(Zones zone) {
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
                GameContext.getContext().getFishingFeature().setZone(zone);
                System.out.println(GameContext.getContext().getFishingFeature().getZone());
            }
        });
    }
}
