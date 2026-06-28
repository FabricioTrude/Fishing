package com.fabricio.fishing.assets;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimatedAsset {
    private final Array<Animation<TextureRegion>> variations;

    public AnimatedAsset(Array<Animation<TextureRegion>> variations) {
        this.variations = variations;
    }

    public Animation<TextureRegion> variation(int n){
        return variations.get(n);
    }

    public Animation<TextureRegion> defaultAnimation(){
        return variations.first();
    }

    public TextureRegion defaultFrame(){
        return defaultAnimation().getKeyFrame(0);
    }

    public Animation<TextureRegion> random(){
        return variations.random();
    }

    public Array<Animation<TextureRegion>> all() {
        return variations;
    }

    public int size(){
        return variations.size;
    }
}

