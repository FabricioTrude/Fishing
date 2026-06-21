package com.fabricio.fishing.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.fabricio.fishing.context.GameContext;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.save.records.LoadGameEvent;
import com.fabricio.fishing.screen.scenes.swamp.SwampPond;
import com.fabricio.fishing.ui.UIManager;

public class GameScreen implements Screen {
    private final static InputMultiplexer multiplexer = new InputMultiplexer();
    public static final UIManager ui = new UIManager();

    final SpriteBatch batch = new SpriteBatch();
    ShapeRenderer renderer = new ShapeRenderer();

    static {
        multiplexer.addProcessor(ui.getStage());
        multiplexer.addProcessor(G.input().clickManager);
        Gdx.input.setInputProcessor(multiplexer);
    }

    public GameScreen() {
        C.init();
        C.ctx().setScene(new SwampPond(C.zone()));
    }

    @Override
    public void show() {
        G.ebus().post(new LoadGameEvent());
    }

    @Override
    public void render(float delta) {
        C.entities().flushRemovals();

        C.entities().update(delta);
        G.time().update(delta);
        G.input().clickManager.update();
        C.scene().update(delta);

        batch.begin();
        C.scene().render(batch);
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
