package com.fabricio.fishing.assets.statics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

public abstract class FeatureAssets {
    static public Texture PlayerTexture = new Texture("features/player/player.png");

    private static final Map<String, TextureAtlas> fishAtlas = new HashMap<>();

    static{
//        atlases.put("legacy",
//            new TextureAtlas("atlas/fishes_legacy.atlas"));
        fishAtlas.put("swamp",
            new TextureAtlas("atlas/fishes_swamp.atlas"));
        fishAtlas.put("oasis",
            new TextureAtlas("atlas/fishes_oasis.atlas"));
    }

    public static TextureRegion getFish(String biome, String fish){
        TextureAtlas atlas = fishAtlas.get(biome);
        if(atlas == null)
            throw new IllegalArgumentException("Atlas não encontrado: " + atlas);
        TextureRegion region = atlas.findRegion(fish);
        if(region == null)
            throw new IllegalArgumentException("Peixe não encontrado: " + fish);
        return region;
    }

    public static void dispose(){
        fishAtlas.values().forEach(TextureAtlas::dispose);
    }
}
