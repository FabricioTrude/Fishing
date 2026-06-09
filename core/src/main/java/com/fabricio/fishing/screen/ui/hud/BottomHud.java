package com.fabricio.fishing.screen.ui.hud;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.fabricio.fishing.assets.IconAssets;
import com.fabricio.fishing.assets.UIAssets;
import com.fabricio.fishing.screen.ui.actors.TextureActor;
import com.fabricio.fishing.screen.ui.buttons.SmallIconButton;
import com.fabricio.fishing.screen.ui.features.FishBackpack;

import static com.fabricio.fishing.features.GameContext.*;

public class BottomHud extends Group {
    final float height = 48;
    final float width = SCREEN_WIDTH;

    static FishBackpack inventory = new FishBackpack();

    public BottomHud() {
        TextureActor background = new TextureActor(UIAssets.BottomHud);
        background.setBounds(0,0,width,height);
        addActor(background);

        addActor(inventory);
        System.out.println("Inventory Hud: " + inventory.getHeight() + "x"+ inventory.getWidth());
        SmallIconButton backpackButton = new SmallIconButton(IconAssets.BackPackIcon, inventory::toggle);
        backpackButton.setBounds(8,8,32,32);
        addActor(backpackButton);
    }
}
