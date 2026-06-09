package com.fabricio.fishing.screen.ui.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.fabricio.fishing.screen.ui.actors.TextureActor;
import com.fabricio.fishing.screen.ui.buttons.SmallIconButton;
import com.fabricio.fishing.screen.ui.groups.FishBackpack;

import static com.fabricio.fishing.features.GameContext.*;

public class BottomHud extends Group {
    final float height = 48;
    final float width = SCREEN_WIDTH;

    static FishBackpack inventory = new FishBackpack();

    public BottomHud() {
        TextureActor background = new TextureActor(new Texture("ui/wood.jpg"));
        background.setBounds(0,0,width,height);
        addActor(background);

        addActor(inventory);
        SmallIconButton backpackButton = new SmallIconButton(new Texture("fishes/bass.png"), inventory::toggle);
        backpackButton.setBounds(10,4,40,40);
        addActor(backpackButton);
    }
}
