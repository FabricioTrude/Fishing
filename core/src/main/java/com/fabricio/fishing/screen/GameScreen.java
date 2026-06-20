package com.fabricio.fishing.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.entity.ClickManager;
import com.fabricio.fishing.save.records.LoadGameEvent;
import com.fabricio.fishing.ui.UIManager;

import static com.fabricio.fishing.features.GameContext.*;

public class GameScreen implements Screen {
    public static final GameContext context = new GameContext();
    private final static InputMultiplexer multiplexer = new InputMultiplexer();
    public static final UIManager ui = new UIManager();
    private final static ClickManager clickManager = new ClickManager();

    final SpriteBatch batch = new SpriteBatch();
    ShapeRenderer renderer = new ShapeRenderer();

    static {
        multiplexer.addProcessor(ui.getStage());
        multiplexer.addProcessor(clickManager);
        Gdx.input.setInputProcessor(multiplexer);
    }

    public GameScreen() {

    }

    @Override
    public void show() {
        eventBus.post(new LoadGameEvent());
    }

    @Override
    public void render(float delta) {
        entityManager.flushRemovals();

        entityManager.update(delta);
        timeManager.update(delta);
        clickManager.update();
        getScene().update(delta);

        batch.begin();
        getScene().render(batch);
        batch.end();
        renderer.setColor(Color.WHITE);

//        entityManager.renderBoxes(renderer); // render hitboxes
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
    }
}
