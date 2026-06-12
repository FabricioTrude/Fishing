package com.fabricio.fishing.screen.ui.generics;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.fabricio.fishing.assets.UIAssets;
import com.fabricio.fishing.screen.ui.actors.TextureActor;

import static com.fabricio.fishing.features.GameContext.SCREEN_HEIGHT;
import static com.fabricio.fishing.features.GameContext.SCREEN_WIDTH;

public abstract class MediumSizePanel extends Group {
    protected float width = 400;
    protected float height = 500;
    protected float x = (SCREEN_WIDTH-width) / 2f;
    protected float y = (SCREEN_HEIGHT-height) / 2f;

    private static MediumSizePanel openedPanel;

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
        Label titleLabel = new Label(title.toUpperCase(), UIAssets.NORMAL);
        titleLabel.setPosition((width - titleLabel.getPrefWidth()) / 2f, height - 30);
        addActor(titleLabel);
    }

    public void toggle(){
        if(isVisible()){
            setVisible(false);
            if(openedPanel == this) openedPanel = null;
            return;
        }
        if(openedPanel != null) openedPanel.setVisible(false);
        setVisible(true);
        openedPanel = this;
    }
}
