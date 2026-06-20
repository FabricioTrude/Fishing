package com.fabricio.fishing.ui.hud;

import com.badlogic.gdx.scenes.scene2d.Group;

public class MainMenu extends Group {

    public void toggle(){
        setVisible(!isVisible());
    }
}
