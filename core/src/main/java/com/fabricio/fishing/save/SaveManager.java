package com.fabricio.fishing.save;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.features.fishing.records.FishCaughtEvent;
import com.fabricio.fishing.save.records.LoadGameEvent;
import com.fabricio.fishing.save.records.SaveGameEvent;

public class SaveManager {
    private static final String SAVE_FILE = "save/save.json";
    private final Json json = new Json();
    InventoryManager inventory;

    public SaveManager(EventBus ebus, InventoryManager inventory){
        this.inventory = inventory;
        ebus.register(SaveGameEvent.class, event -> saveToDisk());
        ebus.register(FishCaughtEvent.class, event -> saveToDisk());
        ebus.register(LoadGameEvent.class, event -> loadFromDisk());
    }

    public SaveData createSave(){
        SaveData save = new SaveData();
        inventory.save(save);
        return save;
    }

    public void loadSave(SaveData save){
        if(save.fishes!=null)inventory.load(save);
    }

    public void saveToDisk(){
        SaveData save = createSave();
        FileHandle file = Gdx.files.local(SAVE_FILE);
        file.writeString(json.toJson(save), false);
    }

    public void loadFromDisk(){
        FileHandle file = Gdx.files.local(SAVE_FILE);
        if(!file.exists()) return;
        SaveData save = json.fromJson(SaveData.class, file.readString());
        if (save != null) loadSave(save);
    }
}
