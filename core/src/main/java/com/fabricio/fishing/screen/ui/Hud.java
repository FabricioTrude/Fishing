package com.fabricio.fishing.screen.ui;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.fabricio.fishing.screen.ui.hud.BottomHud;
import com.fabricio.fishing.screen.ui.hud.TopHud;

public class Hud extends Group {
    public Hud() {
        TopHud topHud = new TopHud();
        BottomHud bottomHud = new BottomHud();

        addActor(topHud);
        addActor(bottomHud);
    }
}
