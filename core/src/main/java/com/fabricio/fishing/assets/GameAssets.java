package com.fabricio.fishing.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;

public class GameAssets {
    private final AssetManager assetManager;

    public GameAssets(){
        assetManager = new AssetManager();
    }

    public void load(){
        assetManager.load(Sounds.FISH_CLICKED, Sound.class);
        assetManager.finishLoading();
    }
    public void dispose(){
        assetManager.dispose();
    }

    public Sound getSound(String path){
       return assetManager.get(path, Sound.class);
    }
}
