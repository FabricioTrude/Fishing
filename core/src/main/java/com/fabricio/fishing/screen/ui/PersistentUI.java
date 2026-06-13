package com.fabricio.fishing.screen.ui;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fabricio.fishing.screen.ui.hud.BottomHud;
import com.fabricio.fishing.screen.ui.hud.TopHud;

public class PersistentUI extends Group {
    private final Stage stage;

    public PersistentUI() {
        this.stage = new Stage(new ScreenViewport());
        TopHud topHud = new TopHud();
        BottomHud bottomHud = new BottomHud();

        stage.addActor(topHud);
        stage.addActor(bottomHud);
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
