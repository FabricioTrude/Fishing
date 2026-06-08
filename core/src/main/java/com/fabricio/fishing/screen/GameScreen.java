package com.fabricio.fishing.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.entity.player.Player;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.manager.*;
import com.fabricio.fishing.util.Palette;

public class GameScreen implements Screen {
    private final EventBus eventBus;
    final TimeManager timeManager;
    final PaletteManager paletteManager;
    final EntityManager entityManager;
    final ClickManager clickManager;
    final ScoreManager scoreManager;

    final Player player;
    final FishManager fishManager;

    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private final SpriteBatch batch = new SpriteBatch();

    public static float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    static public float SEA_HEIGHT = SCREEN_HEIGHT * 0.7f;

    public GameScreen() {
        eventBus = new EventBus();
        timeManager = new TimeManager();
        paletteManager = new PaletteManager(timeManager);
        entityManager = new EntityManager();
        clickManager = new ClickManager(entityManager);
        player = Player.createPlayer(timeManager,entityManager, eventBus);
        fishManager = new FishManager(eventBus, timeManager, entityManager);
        scoreManager = new ScoreManager();

        eventBus.subscribe(entityManager::handle);
        eventBus.subscribe(scoreManager::handle);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        timeManager.update(delta);
        player.update(delta);
        paletteManager.update();
        fishManager.update(delta);
        clickManager.update();
        entityManager.flushRemovals();

        ScreenUtils.clear(paletteManager.getSkyColor());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Palette.SEA);
        shapeRenderer.rect(0,0, SCREEN_WIDTH, SEA_HEIGHT);
        shapeRenderer.end();

//        entityManager.renderBoxes(shapeRenderer); // render colisao

        batch.begin();
        player.render(batch);
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
