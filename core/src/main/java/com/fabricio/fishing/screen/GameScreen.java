package com.fabricio.fishing.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.entity.Player;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.manager.TimeManager;
import com.fabricio.fishing.util.Palette;

public class GameScreen implements Screen {
    static final TimeManager timeManager = new TimeManager(TimePeriod.DAWN);
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();

    float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();

    float seaHeight = screenHeight * 0.7f;

    private final Player player;

    public GameScreen() {
        player = new Player(screenWidth/2-25,seaHeight);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        timeManager.update();
        ScreenUtils.clear(timeManager.getSkyColor());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Palette.SEA);
        shapeRenderer.rect(0,0,screenWidth,seaHeight);
        shapeRenderer.setColor(Palette.FROG);
        shapeRenderer.rect(player.getX(), player.getY(), 50,50);
        shapeRenderer.setColor(Palette.SALMON);
        shapeRenderer.rect(200,20,30,5);
        shapeRenderer.setColor(Palette.BASS);
        shapeRenderer.rect(screenWidth-100, player.getY()-50,40,5);
        shapeRenderer.end();
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
