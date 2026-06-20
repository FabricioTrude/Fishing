package com.fabricio.fishing.ui.generics;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.ui.actors.TextureActor;

import static com.fabricio.fishing.features.GameContext.SCREEN_HEIGHT;
import static com.fabricio.fishing.features.GameContext.SCREEN_WIDTH;

public abstract class MediumSizePanel extends Group {
    protected float width = 400;
    protected float height = 500;
    protected float x = (SCREEN_WIDTH-width) / 2f;
    protected float y = (SCREEN_HEIGHT-height) / 2f;

    public MediumSizePanel(String title) {
        setBounds(x,y,width,height);
        createBackground();
        createTitle(title);
    }
    public void createBackground(){
        TextureActor background = new TextureActor(UIAssets.MediumPanel);
        background.setBounds(0,0,width,height);
        addActor(background);
    }
    public void createTitle(String title){
        Label label = new Label(title.toUpperCase(), UIAssets.NORMAL);
        label.setPosition((width - label.getPrefWidth()) / 2f, height - 30);
        addActor(label);
    }
}
