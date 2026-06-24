package com.fabricio.fishing.context;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.fabricio.fishing.assets.GameAssets;
import com.fabricio.fishing.assets.SoundManager;
import com.fabricio.fishing.entity.input.InputManager;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.manager.TimeManager;
import com.fabricio.fishing.save.InventoryManager;
import com.fabricio.fishing.save.SaveManager;

public class GlobalContext {
    public static float SCREEN_WIDTH = 480;
    public static float SCREEN_HEIGHT = 720;

    EventBus ebus;
    SaveManager save;
    TimeManager time ;
    InputManager input;
    InventoryManager inventory;
    SoundManager sound;
    GameAssets assets;
    OrthographicCamera CO;

    public GlobalContext() {
        ebus = new EventBus();
        time = new TimeManager(ebus);
        input = new InputManager();
        inventory = new InventoryManager(ebus);
        save = new SaveManager(ebus, inventory);
        assets = new GameAssets();
        assets.load();
        sound = new SoundManager(assets, ebus);
        CO = new OrthographicCamera();
    }

    public EventBus ebus() {return ebus;}
    public SaveManager save() {return save;}
    public TimeManager time() {return time;}
    public InputManager input() {return input;}
    public InventoryManager inventory() {return inventory;}
    public SoundManager sound() {return sound;}
    public GameAssets assets() {return assets;}
    public OrthographicCamera CO(){return CO;}

    public static void setScreenWidth(float screenWidth) {
        SCREEN_WIDTH = screenWidth;
    }
    public static void setScreenHeight(float screenHeight) {
        SCREEN_HEIGHT = screenHeight;
    }
}
