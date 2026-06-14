package com.fabricio.fishing.screen.ui;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fabricio.fishing.screen.ui.hud.BottomHud;
import com.fabricio.fishing.screen.ui.hud.TopHud;

import static com.fabricio.fishing.features.GameContext.*;

public class PersistentUI extends Group {
    private final Stage stage;

    public PersistentUI() {
        this.stage = new Stage(new ScreenViewport());
        TopHud topHud = new TopHud();
        topHud.setBounds(0, SCREEN_HEIGHT - 92, SCREEN_WIDTH, 92);
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
