package com.fabricio.fishing.ui;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fabricio.fishing.ui.generics.FadingGroup;
import com.fabricio.fishing.ui.hud.BottomHud;
import com.fabricio.fishing.ui.hud.HudOverlay;
import com.fabricio.fishing.ui.hud.MainMenu;
import com.fabricio.fishing.ui.hud.TopHud;
import com.fabricio.fishing.ui.screens.features.FishBackpackHud;
import com.fabricio.fishing.ui.screens.features.ZonesHud;

import static com.fabricio.fishing.context.GlobalContext.*;

public class UIManager {
    public Toggle toggle;
    private final Stage stage;

    final HudOverlay overlay;

    final FishBackpackHud inventory;
    final ZonesHud zones;
    final MainMenu menu;

    final FadingGroup hudGroup = new FadingGroup();
    final TopHud topHud;
    final BottomHud bottomHud;

    public UIManager() {
        toggle = new Toggle();
        this.stage = new Stage(new ScreenViewport());

        this.overlay = new HudOverlay();
        stage.addActor(overlay);

        inventory = new FishBackpackHud();
        zones = new ZonesHud();
        menu = new MainMenu();
        stage.addActor(inventory);
        stage.addActor(zones);
        stage.addActor(menu);

        this.topHud = new TopHud();
        this.bottomHud = new BottomHud(this);
        hudGroup.addActor(topHud);
        hudGroup.addActor(bottomHud);
        stage.addActor(hudGroup);
    }

    public void update(float delta) {
        stage.act(delta);
    }

    public void render() {
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }

    public class Toggle {
        private Group openedPanel = null;
        private boolean hudHidden;

        public void toggle(Group panel) {
            if (openedPanel == panel) {
                panel.setVisible(false);
                openedPanel = null;
                overlay.setVisible(false);
                return;
            }
            if (openedPanel != null) {
                openedPanel.setVisible(false);
            }
            panel.setVisible(true);
            openedPanel = panel;
            overlay.setVisible(true);
        }

        public void toggleHud(){
            topHud.clearActions();
            bottomHud.clearActions();
            if(hudHidden) {

                topHud.addAction(
                    Actions.moveTo(
                        topHud.getX(),
                        SCREEN_HEIGHT - topHud.getHeight(),
                        0.3f,
                        Interpolation.sine
                    )
                );

                bottomHud.addAction(
                    Actions.moveTo(
                        bottomHud.getX(),
                        0,
                        0.3f,
                        Interpolation.smooth
                    )
                );

            } else {

                topHud.addAction(
                    Actions.moveTo(
                        topHud.getX(),
                        SCREEN_HEIGHT,
                        0.3f,
                        Interpolation.sine
                    )
                );
                bottomHud.addAction(
                    Actions.moveTo(
                        bottomHud.getX(),
                        - bottomHud.getHeight(),
                        0.3f,
                        Interpolation.smooth
                    )
                );
            }
            hudHidden = !hudHidden;
        }

        public void toggleInventory() {
            toggle(inventory);
        }

        public void toggleMenu() {
            toggle(menu);
        }

        public void toggleZones() {
            toggle(zones);
        }

        public boolean isHidden() {
            return hudHidden;
        }
    }
}
