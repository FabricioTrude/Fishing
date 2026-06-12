package com.fabricio.fishing.screen.ui.hud;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.fabricio.fishing.assets.IconAssets;
import com.fabricio.fishing.assets.UIAssets;
import com.fabricio.fishing.screen.ui.actors.TextureActor;
import com.fabricio.fishing.screen.ui.features.ZonesHud;
import com.fabricio.fishing.screen.ui.generics.SmallIconButton;
import com.fabricio.fishing.screen.ui.features.FishBackpackHud;

import static com.fabricio.fishing.features.GameContext.*;

public class BottomHud extends Group {
    final float height = 72;
    final float width = SCREEN_WIDTH;

    static FishBackpackHud inventory = new FishBackpackHud();
    static ZonesHud zones = new ZonesHud();

    public BottomHud() {
        TextureActor background = new TextureActor(UIAssets.BottomHud);
        background.setBounds(0,0,width,height);
        addActor(background);

        createButtons();
    }

    private void createButtons(){
        SmallIconButton backpackButton = new SmallIconButton(IconAssets.BackPackIcon, inventory::toggle);
        backpackButton.setBounds(4,4,64,64);
        addActor(backpackButton);

        addActor(new SmallIconButton(IconAssets.QuestionMarkIcon, () -> {}).bounds(68 + 4,4,64,64));
        addActor(new SmallIconButton(IconAssets.QuestionMarkIcon, () -> {}).bounds(68 + 68 + 4,4,64,64));
        addActor(new SmallIconButton(IconAssets.MenuIcon, () -> {}).bounds(68 + 68 + 68 + 4,4,64,64));

        SmallIconButton zonesButton = new SmallIconButton(IconAssets.MapIcon, zones::toggle);
        zonesButton.setBounds(68 + 68 + 68 + 4 + 68 + 68 + 68,4,64,64);
        addActor(zonesButton);

        addActor(inventory);
        addActor(zones);
    }
}
