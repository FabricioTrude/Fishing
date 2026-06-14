package com.fabricio.fishing.screen.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fabricio.fishing.assets.statics.IconAssets;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.screen.ui.actors.TextureActor;
import com.fabricio.fishing.screen.ui.screens.features.ZonesHud;
import com.fabricio.fishing.screen.ui.generics.SmallIconButton;
import com.fabricio.fishing.screen.ui.screens.features.FishBackpackHud;

import static com.fabricio.fishing.features.GameContext.*;

public class BottomHud extends Group {
    final float height = 72;
    final float width = SCREEN_WIDTH;

    static FishBackpackHud inventory = new FishBackpackHud();
    static ZonesHud zones = new ZonesHud();

    Group outsideGroup = new Group();
    FadingGroup fadingGroup = new FadingGroup();
    public BottomHud() {
        addActor(fadingGroup);
        addActor(outsideGroup);
        TextureActor background = new TextureActor(UIAssets.BottomHud);
        background.setBounds(0,0,width,height);
        fadingGroup.addActor(background);

        createButtons();
        fadingGroup.getColor().a = 0.3f;
    }

    private void createButtons(){
        SmallIconButton backpackButton = new SmallIconButton(IconAssets.BackPackIcon, inventory::toggle);
        backpackButton.setBounds(4,4,64,64);
        fadingGroup.addActor(backpackButton);

        fadingGroup.addActor(new SmallIconButton(IconAssets.QuestionMarkIcon, () -> {}).bounds(68 + 4,4,64,64));
        fadingGroup.addActor(new SmallIconButton(IconAssets.QuestionMarkIcon, () -> {}).bounds(68 + 68 + 4,4,64,64));
        fadingGroup.addActor(new SmallIconButton(IconAssets.MenuIcon, () -> {}).bounds(68 + 68 + 68 + 4,4,64,64));

        SmallIconButton zonesButton = new SmallIconButton(IconAssets.MapIcon, zones::toggle);
        zonesButton.setBounds(68 + 68 + 68 + 4 + 68 + 68 + 68,4,64,64);
        fadingGroup.addActor(zonesButton);

        outsideGroup.addActor(inventory);
        outsideGroup.addActor(zones);
    }

}
class FadingGroup extends Group{
    protected boolean hovered = false;

    @Override
    public void act(float delta) {
        super.act(delta);
        Vector2 mouse = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        getStage().screenToStageCoordinates(mouse);

        Actor hit = getStage().hit(mouse.x, mouse.y, true);

        boolean isHovered =
            hit != null &&
                (hit == this || hit.isDescendantOf(this));

        if (isHovered != hovered) {
            hovered = isHovered;

            clearActions();

            if (hovered) {
                this.addAction(Actions.alpha(1f, 0.2f, Interpolation.fade));
            } else {
                this.addAction(Actions.alpha(0.3f, 0.5f, Interpolation.fade));
            }
        }
    }
}
