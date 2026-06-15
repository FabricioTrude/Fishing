package com.fabricio.fishing.features;

import com.badlogic.gdx.Gdx;
import com.fabricio.fishing.assets.GameAssets;
import com.fabricio.fishing.assets.SoundManager;
import com.fabricio.fishing.entity.ClickManager;
import com.fabricio.fishing.entity.EntityManager;
import com.fabricio.fishing.features.zones.Zones;
import com.fabricio.fishing.features.player.Player;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.manager.*;
import com.fabricio.fishing.save.InventoryManager;
import com.fabricio.fishing.save.SaveManager;
import com.fabricio.fishing.screen.Scene;
import com.fabricio.fishing.screen.scenes.DefaultPond;
import com.fabricio.fishing.screen.scenes.swamp.SwampPond;

public final class GameContext {
    public static float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static float SCREEN_HEIGHT = Gdx.graphics.getHeight();

    public static final EventBus eventBus = new EventBus();

    public static final EntityManager entityManager = new EntityManager();
    public static final Player player = Player.createPlayer();

    public static final SaveManager saveManager = new SaveManager();
    public static SoundManager soundManager;
    public static final TimeManager timeManager = new TimeManager() ;
    public static final ClickManager clickManager = new ClickManager();
    public static final InventoryManager inventoryManager = new InventoryManager();
    public static final ScoreManager scoreManager = new ScoreManager();

    public static final GameAssets gameAssets = new GameAssets();

    public static Zones zone = Zones.SWAMP;
    private static Scene scene = new SwampPond();

    public GameContext() {
        gameAssets.load();
        soundManager = new SoundManager(gameAssets);
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setZone(Zones zoneType) {
        if (scene != null) scene.dispose();
        zone = zoneType;
        switch (zoneType) {
            case SWAMP -> scene = new SwampPond();
            default -> scene = new DefaultPond();
        }
    }

    public static void setScreenWidth(float screenWidth) {
        SCREEN_WIDTH = screenWidth;
    }

    public static void setScreenHeight(float screenHeight) {
        SCREEN_HEIGHT = screenHeight;
    }
}
