package com.fabricio.fishing.assets;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.assets.enums.SFX;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.features.fishing.records.FishClickedEvent;

public class AudioManager {
    private final GameAssets assets;
    private Music currentMusic;
    float musicVolume = 0.1f;
    float soundVolume = 1f;

    public AudioManager(GameAssets gameAssets, EventBus ebus){
        assets = gameAssets;
        ebus.register(FishClickedEvent.class, this::onFishClick);
    }

    public void onFishClick(FishClickedEvent e){
        playSound(SFX.FISH_CLICKED, 1f / (e.fish().getScale() * MathUtils.random(0.7f,1.2f)));
    }

    public void playSound(SFX sfx, Float pitch){
        Sound sound = assets.getSound(sfx);
        long id = sound.play(soundVolume);
        sound.setPitch(id, pitch);
    }

    public void playMusic(SFX sfx, boolean looping){
        if(currentMusic != null) currentMusic.stop();
        currentMusic = assets.getMusic(sfx);
        currentMusic.setLooping(looping);
        currentMusic.setVolume(musicVolume);
        currentMusic.play();
    }

    public void stopMusic(){
        if(currentMusic != null) currentMusic.stop();
    }
    public void setMusicVolume(float volume){
        soundVolume = volume;
    }
    public void dispose(){
        stopMusic();
    }
}
