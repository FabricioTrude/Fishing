package com.fabricio.fishing.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.features.fishing.FishingFeature;
import com.fabricio.fishing.manager.ClickManager;
import com.fabricio.fishing.manager.records.LoadGameEvent;

import static com.fabricio.fishing.features.GameContext.eventBus;

public class GameScreen implements Screen {
    private final GameContext context = new GameContext();

    private InputMultiplexer multiplexer;
    private UIManager uiManager;
    private ClickManager clickManager;

    public GameScreen() {
        context.setFeature(new FishingFeature(context));
        context.render();
    }

    @Override
    public void show() {
        eventBus.post(new LoadGameEvent());
        uiManager = new UIManager();
        clickManager = new ClickManager(context.getEntityManager());
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(uiManager.getStage());
        multiplexer.addProcessor(clickManager);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        context.update(delta);
        context.render();
        clickManager.update();
        uiManager.update(delta);
        uiManager.render();
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
