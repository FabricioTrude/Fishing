package com.fabricio.fishing.ui.hud;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.manager.records.TickEvent;
import com.fabricio.fishing.ui.actors.TextureActor;

import static com.fabricio.fishing.assets.statics.UIAssets.NORMAL;
import static com.fabricio.fishing.context.GlobalContext.*;

public class TopHud extends Group {
    final float height = 92;
    static float width = SCREEN_WIDTH;

    public TopHud() {
        setBounds(0,SCREEN_HEIGHT-height, SCREEN_WIDTH, height);
        TextureActor background = new TextureActor(UIAssets.TopHud);
        background.setBounds(0,0, width, height);
        addActor(background);

        Label label = new Label(G.time().getClock(), NORMAL);
        G.ebus().register(TickEvent.class, e -> label.setText(e.time()));
        label.setPosition(width - 70, (height - label.getPrefHeight()) / 2);
        addActor(label);
    }
}
