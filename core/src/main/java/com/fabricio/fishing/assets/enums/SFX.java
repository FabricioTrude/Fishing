package com.fabricio.fishing.assets.enums;

public enum SFX {
    //SOUNDS
    FISH_CLICKED("audio/sounds/fish_clicked.wav"),
    //MUSIC
    //https://pixabay.com/music/ambient-melancholic-ambient-background-351787/
    SWAMP_POND("audio/music/melancholic-ambient.mp3"),
    //https://opengameart.org/content/crystal-cave-song18
    SWAMP_CAVE("audio/music/crystal_cave.mp3");

    public final String path;

    SFX(String path){
        this.path = path;
    }
}
