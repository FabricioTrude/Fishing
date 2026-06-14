package com.fabricio.fishing.screen.ui.hud;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.manager.records.TickEvent;
import com.fabricio.fishing.screen.ui.actors.TextureActor;

import static com.fabricio.fishing.assets.statics.UIAssets.NORMAL;
import static com.fabricio.fishing.features.GameContext.*;

public class TopHud extends Group {
    final float height = 92;
    static float width = SCREEN_WIDTH;
    public TopHud() {
        TextureActor background = new TextureActor(UIAssets.TopHud);
        background.setBounds(0,0, width, height);
        fadingGroup.addActor(background);

        Label label = new Label(timeManager.getClock(), NORMAL);
        eventBus.register(TickEvent.class, e -> label.setText(e.time()));
        label.setPosition(width - 70, (height - label.getPrefHeight()) / 2);
        fadingGroup.addActor(label);

        addActor(outsideGroup);
        addActor(fadingGroup);
    }

    Group outsideGroup = new Group();
    FadingGroup fadingGroup = new FadingGroup();
}
