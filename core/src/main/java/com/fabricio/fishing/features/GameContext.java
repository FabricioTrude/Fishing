package com.fabricio.fishing.features;

import com.badlogic.gdx.Gdx;
import com.fabricio.fishing.assets.GameAssets;
import com.fabricio.fishing.assets.SoundManager;
import com.fabricio.fishing.entity.ClickManager;
import com.fabricio.fishing.entity.EntityManager;
import com.fabricio.fishing.features.player.Player;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.manager.*;
import com.fabricio.fishing.save.InventoryManager;
import com.fabricio.fishing.save.SaveManager;
import com.fabricio.fishing.screen.FeatureScreen;

public final class GameContext {
    private static GameContext INSTANCE;
    public static float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public static float SEA_HEIGHT = SCREEN_HEIGHT * 0.7f;
    public static final EventBus eventBus = new EventBus();
    public static final SaveManager saveManager = new SaveManager();
    public static SoundManager soundManager;

    public static final TimeManager timeManager = new TimeManager() ;
    public static final EntityManager entityManager = new EntityManager();
    public static final ClickManager clickManager = new ClickManager();
    public static final ScoreManager scoreManager = new ScoreManager();
    public static final GameAssets gameAssets = new GameAssets();
    public static final Player player = Player.createPlayer();

    public static final InventoryManager inventoryManager = new InventoryManager();

    private FeatureScreen currentFeature;

    public GameContext() {
        INSTANCE = this;
        gameAssets.load();
        soundManager = new SoundManager(gameAssets);
    }

    public static GameContext getContext(){
        return INSTANCE;
    }

    public static ScoreManager getScoreManager() {
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

    public static void setSeaHeight(float seaHeight) {
        SEA_HEIGHT = seaHeight;
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
