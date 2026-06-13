package com.fabricio.fishing.screen.ui.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.screen.ui.actors.ColorActor;
import com.fabricio.fishing.screen.ui.actors.TextureActor;

import static com.fabricio.fishing.features.GameContext.*;

public class TopHud extends Group {
    final float height = 92;
    static float width = SCREEN_WIDTH;
    private final ColorActor bg = new ColorActor(Color.WHITE);
    public TopHud() {
        TextureActor background = new TextureActor(UIAssets.TopHud);
        background.setBounds(0,SCREEN_HEIGHT - height, width, height);
        addActor(background);
    }
}
