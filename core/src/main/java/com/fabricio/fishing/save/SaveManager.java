package com.fabricio.fishing.save;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.fabricio.fishing.event.records.FishCaughtEvent;

import static com.fabricio.fishing.features.GameContext.*;

public class SaveManager {

    private static final String SAVE_FILE = "save.json";
    private final Json json = new Json();

    public SaveManager(){
        eventBus.register(SaveGameEvent.class, event -> saveToDisk());
        eventBus.register(FishCaughtEvent.class, event -> saveToDisk());
        eventBus.register(LoadGameEvent.class, event -> loadFromDisk());
    }

    public SaveData createSave(){
        SaveData save = new SaveData();
        inventoryManager.save(save);
        return save;
    }

    public void loadSave(SaveData save){
        if(save.fishes!=null)inventoryManager.load(save);
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
