package com.fabricio.fishing.assets.statics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.fabricio.fishing.assets.AnimatedAsset;
import com.fabricio.fishing.assets.FeatureType;
import com.fabricio.fishing.assets.enums.AtlasId;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public abstract class FeatureAssets {
    public static Texture PlayerTexture = new Texture("features/player/player.png");

    private static final Map<AtlasId, TextureAtlas> atlases =
        new EnumMap<>(AtlasId.class);

    private static final Map<FeatureType, AnimatedAsset> cache =
        new HashMap<>();

    static {
        for (AtlasId atlasId : AtlasId.values()) {
            atlases.put(
                atlasId,
                new TextureAtlas(atlasId.path())
            );
        }
    }

    public static AnimatedAsset get(FeatureType type) {
        return cache.computeIfAbsent(
            type,
            FeatureAssets::loadAsset
        );
    }

    private static AnimatedAsset loadAsset(FeatureType type) {

        TextureAtlas atlas = atlases.get(type.atlas());

        Array<Animation<TextureRegion>> vars = new Array<>();

        // Procura variações: bass_1, bass_2...
        for (int i = 1; ; i++) {

            Array<TextureAtlas.AtlasRegion> frames =
                atlas.findRegions(type.id() + "_" + i);

            if (frames.isEmpty())
                break;

            vars.add(new Animation<>(0.2f, frames));
        }

        // Nenhuma variação encontrada?
        // Tenta carregar o asset base
        if (vars.isEmpty()) {

            Array<TextureAtlas.AtlasRegion> frames =
                atlas.findRegions(type.id());

            // Caso seja um sprite estático sem índices
            if (frames.isEmpty()) {

                TextureAtlas.AtlasRegion region =
                    atlas.findRegion(type.id());

                if (region != null) {
                    frames.add(region);
                }
            }

            if (!frames.isEmpty()) {
                vars.add(new Animation<>(0.2f, frames));
            }
        }

        if (vars.isEmpty()) {
            throw new IllegalArgumentException(
                "Nenhum asset encontrado para "
                    + type.id()
                    + " no atlas "
                    + type.atlas()
            );
        }

        return new AnimatedAsset(vars);
    }

    public static void dispose() {
        atlases.values().forEach(TextureAtlas::dispose);
    }
}
