package com.fabricio.fishing.screen.ui.groups;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.fabricio.fishing.screen.ui.actors.TextureActor;

import static com.fabricio.fishing.features.GameContext.*;

public class FishBackpack extends Group {
    public FishBackpack() {
        TextureActor background = new TextureActor(new Texture("ui/wood.jpg"));
        float width = 400;
        float height = 500;

        background.setBounds(0,0,width,height);
        addActor(background);
        setBounds((SCREEN_WIDTH-width) / 2f, (SCREEN_HEIGHT-height) / 2f, width, height);
        setVisible(false);
    }
    public void toggle(){
        setVisible(!isVisible());
    }
}
