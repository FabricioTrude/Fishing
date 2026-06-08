package com.fabricio.fishing.features;

import com.badlogic.gdx.Gdx;
import com.fabricio.fishing.entity.player.Player;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.manager.*;
import com.fabricio.fishing.screen.FeatureScreen;

public class GameContext {
    public static float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    static public float SEA_HEIGHT = SCREEN_HEIGHT * 0.7f;

    private final EventBus eventBus = new EventBus();
    private final TimeManager timeManager = new TimeManager() ;
    private final PaletteManager paletteManager = new PaletteManager(timeManager);
    private final EntityManager entityManager = new EntityManager();
    private final ClickManager clickManager = new ClickManager(entityManager);
    private final ScoreManager scoreManager = new ScoreManager();
    private Player player = Player.createPlayer(timeManager, entityManager, eventBus);

    private FeatureScreen currentFeature;

    public GameContext() {
        eventBus.subscribe(entityManager::handle);
        eventBus.subscribe(scoreManager::handle);
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public TimeManager getTimeManager() {
        return timeManager;
    }

    public PaletteManager getPaletteManager() {
        return paletteManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public ClickManager getClickManager() {
        return clickManager;
    }

    public ScoreManager getScoreManager() {
        return scoreManager;
    }

    public FeatureScreen getCurrentFeature() {
        return currentFeature;
    }

    public Player getPlayer() {
        return player;
    }

    public static void setScreenWidth(float screenWidth) {
        SCREEN_WIDTH = screenWidth;
    }

    public static void setScreenHeight(float screenHeight) {
        SCREEN_HEIGHT = screenHeight;
    }

    public void setFeature(FeatureScreen feature){
        currentFeature = feature;
    }

    public void update(float delta){
        if(currentFeature == null) return;
        currentFeature.update(delta);
    }
    public void render(){
        if(currentFeature == null) return;
        currentFeature.render();
    }
}
