package com.fabricio.fishing.screen;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fabricio.fishing.screen.ui.MainHud;

public class PersistentUI {
    private final Stage stage;

    public PersistentUI() {
        this.stage = new Stage(new ScreenViewport());
        MainHud hud = new MainHud();
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

    public void dispose(){stage.dispose();}
}
