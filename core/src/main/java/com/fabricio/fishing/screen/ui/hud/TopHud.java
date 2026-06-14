package com.fabricio.fishing.screen.ui.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.screen.ui.actors.ColorActor;
import com.fabricio.fishing.screen.ui.actors.TextureActor;

import static com.fabricio.fishing.features.GameContext.*;

public class TopHud extends Group {
    final float height = 92;
    static float width = SCREEN_WIDTH;
    public TopHud() {
        TextureActor background = new TextureActor(UIAssets.TopHud);
        background.setBounds(0,SCREEN_HEIGHT - height, width, height);
        addActor(background);

        getColor().a = 0.3f;
        addListener(new ClickListener(){
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                clearActions();
                addAction(Actions.alpha(1f, 0.2f, Interpolation.fade));
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                clearActions();
                addAction(Actions.alpha(0.3f, 0.5f, Interpolation.fade));
            }
        });
    }
}
