package com.fabricio.fishing.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.fabricio.fishing.assets.enums.SFX;

public class GameAssets {
    private final AssetManager assetManager;

    public GameAssets(){
        assetManager = new AssetManager();
    }

    public void load(){
        assetManager.load(SFX.FISH_CLICKED.path, Sound.class);
        assetManager.load(SFX.SWAMP_CAVE.path, Music.class);
        assetManager.load(SFX.SWAMP_POND.path, Music.class);
        assetManager.finishLoading();
    }

    public Sound getSound(SFX sfx){return assetManager.get(sfx.path, Sound.class);}
    public Music getMusic(SFX sfx){return assetManager.get(sfx.path, Music.class);}
}
