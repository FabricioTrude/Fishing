package com.fabricio.fishing.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.entity.Player;
import com.fabricio.fishing.manager.*;
import com.fabricio.fishing.util.Palette;

public class GameScreen implements Screen {
    final TimeManager timeManager;
    final PaletteManager paletteManager;
    final EntityManager entityManager;
    final FishManager fishManager;
    final ClickManager clickManager;

    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private final SpriteBatch batch = new SpriteBatch();

    public static float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    static public float SEA_HEIGHT = SCREEN_HEIGHT * 0.7f;

    private final Player player;

    public GameScreen() {
        player = new Player(SCREEN_WIDTH /2-25, SEA_HEIGHT);
        timeManager = new TimeManager();
        paletteManager = new PaletteManager(timeManager);
        entityManager = new EntityManager();
        fishManager = new FishManager(timeManager, entityManager);
        clickManager = new ClickManager(entityManager);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        timeManager.update(delta);
        paletteManager.update();
        fishManager.update(delta);
        clickManager.update();
        entityManager.flushRemovals();

        ScreenUtils.clear(paletteManager.getSkyColor());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Palette.SEA);
        shapeRenderer.rect(0,0, SCREEN_WIDTH, SEA_HEIGHT);
        shapeRenderer.end();
 //       entityManager.renderBoxes(shapeRenderer); // render colisao

        batch.begin();
        fishManager.render(batch);
        batch.end();
    }

    @Override
    public void resize(int i, int i1) {
        SCREEN_HEIGHT = Gdx.graphics.getHeight();
        SCREEN_WIDTH = Gdx.graphics.getWidth();
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
