package com.fabricio.fishing.screen;

import com.badlogic.gdx.Screen;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.features.fishing.FishingFeature;
import com.fabricio.fishing.manager.*;

public class GameScreen implements Screen {
    private final GameContext context = new GameContext();

    public GameScreen() {
        context.setFeature(new FishingFeature(context));
        context.render();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        context.update(delta);
        context.render();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
