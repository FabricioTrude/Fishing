package com.fabricio.fishing.ui.hud;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.manager.records.TickEvent;
import com.fabricio.fishing.ui.actors.TextureActor;
import com.fabricio.fishing.ui.generics.FadingGroup;

import static com.fabricio.fishing.assets.statics.UIAssets.NORMAL;
import static com.fabricio.fishing.features.GameContext.*;

public class TopHud extends Group {
    final float height = 92;
    static float width = SCREEN_WIDTH;

    public TopHud() {
        setBounds(0,SCREEN_HEIGHT-height, SCREEN_WIDTH, height);
        TextureActor background = new TextureActor(UIAssets.TopHud);
        background.setBounds(0,0, width, height);
        addActor(background);

        Label label = new Label(timeManager.getClock(), NORMAL);
        eventBus.register(TickEvent.class, e -> label.setText(e.time()));
        label.setPosition(width - 70, (height - label.getPrefHeight()) / 2);
        addActor(label);
    }
}
