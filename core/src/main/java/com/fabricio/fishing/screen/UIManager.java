package com.fabricio.fishing.screen;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fabricio.fishing.screen.ui.Hud;

public class UIManager {
    private final Stage stage;

    public UIManager() {
        this.stage = new Stage(new ScreenViewport());
        Hud hud = new Hud();
        stage.addActor(hud);
    }

    public Stage getStage() {
        return stage;
    }

    public void update(float delta){
        stage.act(delta);
    }

    public void render(){
        stage.draw();
    }
}
