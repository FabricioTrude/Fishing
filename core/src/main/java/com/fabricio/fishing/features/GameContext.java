package com.fabricio.fishing.features;

import com.badlogic.gdx.Gdx;
import com.fabricio.fishing.assets.GameAssets;
import com.fabricio.fishing.assets.SoundManager;
import com.fabricio.fishing.entity.EntityManager;
import com.fabricio.fishing.entity.player.Player;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.features.fishing.FishingFeature;
import com.fabricio.fishing.manager.*;
import com.fabricio.fishing.save.InventoryManager;
import com.fabricio.fishing.save.LoadGameEvent;
import com.fabricio.fishing.save.SaveGameEvent;
import com.fabricio.fishing.save.SaveManager;
import com.fabricio.fishing.screen.FeatureScreen;

public final class GameContext {
    private static GameContext INSTANCE;

    public static float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public static float SEA_HEIGHT = SCREEN_HEIGHT * 0.7f;
    public static final EventBus eventBus = new EventBus();
    public static final InventoryManager inventoryManager = new InventoryManager();
    public static final SaveManager saveManager = new SaveManager();
    public static SoundManager soundManager;

    private final TimeManager timeManager = new TimeManager() ;
    private final PaletteManager paletteManager = new PaletteManager(timeManager);
    private final EntityManager entityManager = new EntityManager();
    private final ClickManager clickManager = new ClickManager(entityManager);
    private final ScoreManager scoreManager = new ScoreManager();
    private final GameAssets gameAssets = new GameAssets();
    private Player player = Player.createPlayer(timeManager, entityManager);

    private FeatureScreen currentFeature;

    public GameContext() {
        INSTANCE = this;
        gameAssets.load();
        soundManager = new SoundManager(gameAssets);
    }

    public static GameContext getContext(){
        return INSTANCE;
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

    public InventoryManager getInventoryManager(){
        return inventoryManager;
    }

    public ScoreManager getScoreManager() {
        return scoreManager;
    }

    public FeatureScreen getCurrentFeature() {
        return currentFeature;
    }

    public FishingFeature getFishingFeature(){
        if (currentFeature instanceof FishingFeature fishing) return fishing;
        return null;
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
