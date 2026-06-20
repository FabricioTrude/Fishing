package com.fabricio.fishing.ui.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.fabricio.fishing.ui.actors.ColorActor;

import static com.fabricio.fishing.features.GameContext.SCREEN_HEIGHT;
import static com.fabricio.fishing.features.GameContext.SCREEN_WIDTH;

public class HudOverlay extends Group {
    protected ColorActor bg;

    public HudOverlay() {
        bg = new ColorActor(Color.valueOf("0a0a0aca"));
        bg.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
        addActor(bg);
        setVisible(false);
    }
}
