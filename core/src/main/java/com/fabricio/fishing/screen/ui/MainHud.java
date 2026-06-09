package com.fabricio.fishing.screen.ui;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.fabricio.fishing.screen.ui.hud.BottomHud;
import com.fabricio.fishing.screen.ui.hud.TopHud;

public class MainHud extends Group {
    public MainHud() {
        TopHud topHud = new TopHud();
        BottomHud bottomHud = new BottomHud();

        addActor(topHud);
        addActor(bottomHud);
    }
}
