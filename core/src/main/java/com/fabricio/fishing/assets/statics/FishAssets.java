package com.fabricio.fishing.assets.statics;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

public class FishAssets {
    private static final Map<String, TextureAtlas> atlases = new HashMap<>();

    static{
//        atlases.put("legacy",
//            new TextureAtlas("atlas/fishes_legacy.atlas"));
        atlases.put("swamp",
            new TextureAtlas("atlas/fishes_swamp.atlas"));
        atlases.put("oasis",
            new TextureAtlas("atlas/fishes_oasis.atlas"));
    }

    public static TextureRegion get(String biome, String fish){
        TextureAtlas atlas = atlases.get(biome);
        if(atlas == null)
            throw new IllegalArgumentException("Atlas não encontrado: " + atlas);
        TextureRegion region = atlas.findRegion(fish);
        if(region == null)
            throw new IllegalArgumentException("Peixe não encontrado: " + fish);
        return region;
    }

    public static void dispose(){
        atlases.values().forEach(TextureAtlas::dispose);
    }
}
