package com.fabricio.fishing.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.entity.ClickManager;
import com.fabricio.fishing.save.records.LoadGameEvent;
import com.fabricio.fishing.screen.ui.PersistentUI;

import static com.fabricio.fishing.features.GameContext.eventBus;

public class GameScreen implements Screen {
    private static final GameContext context = new GameContext();
    private final static InputMultiplexer multiplexer = new InputMultiplexer();
    private final static PersistentUI ui = new PersistentUI();
    private final static ClickManager clickManager = new ClickManager();

    static {
        multiplexer.addProcessor(ui.getStage());
        multiplexer.addProcessor(clickManager);
        Gdx.input.setInputProcessor(multiplexer);
    }

    public GameScreen() {
        context.setFeature(new FishingScreen());
        context.render();
    }

    @Override
    public void show() {
        eventBus.post(new LoadGameEvent());
    }

    @Override
    public void render(float delta) {
        context.update(delta);
        context.render();
        clickManager.update();
        ui.update(delta);
        ui.render();
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
        context.getCurrentFeature().dispose();
        ui.dispose();
    }
}
