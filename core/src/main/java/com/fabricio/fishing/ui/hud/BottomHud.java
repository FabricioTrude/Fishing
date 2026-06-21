package com.fabricio.fishing.ui.hud;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fabricio.fishing.assets.statics.IconAssets;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.ui.UIManager;
import com.fabricio.fishing.ui.actors.TextureActor;
import com.fabricio.fishing.ui.generics.SmallIconButton;

import static com.fabricio.fishing.context.GlobalContext.*;

public class BottomHud extends Group {
    final float height = 52;
    final float width = SCREEN_WIDTH;

    UIManager ui;

    float buttons = 7;
    float slotWidth = SCREEN_WIDTH / 7f;
    float buttonSize = 36;

    public BottomHud(UIManager ui) {
        this.ui = ui;
        setBounds(0,0,width,height);
        TextureActor background = new TextureActor(UIAssets.BottomHud);
        addActor(background);
        createButtons();
    }

    private void createButtons(){
        SmallIconButton.setButtonSize(buttonSize);
        for(int slot = 0; slot < buttons; slot++){
            float x = slot * slotWidth + (slotWidth - buttonSize ) / 2f;
            float y = (height - buttonSize) / 2;

            SmallIconButton button = null;

            switch(slot){
                case 0 -> button = new SmallIconButton(
                    IconAssets.BackPackIcon,
                    ui.toggle::toggleInventory
                );
                case 1,2 -> button = new SmallIconButton(
                    IconAssets.QuestionMarkIcon,
                    () -> {}
                );
                case 3 -> button = new SmallIconButton(
                    IconAssets.MenuIcon,
                    ui.toggle::toggleMenu
                );
                case 6 -> button = new SmallIconButton(
                    IconAssets.MapIcon,
                    ui.toggle::toggleZones
                );
                default -> {continue;}
            }
            button.setBounds(x,y,buttonSize, buttonSize);
            addActor(button);
        }
        Group toggleButton = new Group();
        TextureActor tgbg = new TextureActor(UIAssets.ToggleHudButton);
        toggleButton.addActor(tgbg);
        toggleButton.setBounds(SCREEN_WIDTH - tgbg.getWidth(),height, tgbg.getWidth(), tgbg.getHeight());
        TextureActor tgoverlay = new TextureActor(IconAssets.YellowArrow);
        tgoverlay.setOrigin(toggleButton.getWidth() / 2f, toggleButton.getHeight() / 2f);
        toggleButton.addActor(tgoverlay);
        toggleButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ui.toggle.toggleHud();
                tgoverlay.addAction(Actions.rotateTo(
                    ui.toggle.isHidden() ? 180 : 0,
                    0.25f,
                    Interpolation.sine
                ));
            }
        });
        addActor(toggleButton);
    }

}
