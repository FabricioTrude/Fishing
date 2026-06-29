package com.fabricio.fishing.ui.generics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.ui.actors.TextureActor;

public class SmallIconButton extends Group {

    private static float buttonSize = 16;

    public SmallIconButton(Texture icon, Runnable onClick) {
        TextureActor background = new TextureActor(UIAssets.SmallIconButton);
        TextureActor iconActor = new TextureActor(icon);
        background.setBounds(0,0,buttonSize,buttonSize);
        iconActor.setBounds(0,0,buttonSize,buttonSize);
        addActor(background);
        addActor(iconActor);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                onClick.run();
            }
        });
    }
    public SmallIconButton bounds(float x, float y, float width, float height) {
        setBounds(x,y,width,height);
        return this;
    }

    public static void setButtonSize(float buttonSize) {
        SmallIconButton.buttonSize = buttonSize;
    }
}
