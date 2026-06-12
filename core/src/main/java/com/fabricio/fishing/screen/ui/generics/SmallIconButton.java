package com.fabricio.fishing.screen.ui.generics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fabricio.fishing.assets.UIAssets;
import com.fabricio.fishing.screen.ui.actors.TextureActor;

public class SmallIconButton extends Group {

    public SmallIconButton(Texture icon, Runnable onClick) {
        TextureActor background = new TextureActor(UIAssets.SmallIconButton);
        TextureActor iconActor = new TextureActor(icon);
        background.setBounds(0,0,64,64);
        iconActor.setBounds(0,0,64,64);
        iconActor.setScale(2.5f);
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
}
