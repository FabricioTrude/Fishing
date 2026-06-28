package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fabricio.fishing.assets.AnimatedAsset;

public class StaticEntity extends SpriteEntity{
    public StaticEntity(float x, float y, float z, TextureRegion texture) {
        super(x, y, z, texture);
        centered = false;
    } public StaticEntity(float x, float y, float z, Texture texture){this(x,y,z,new TextureRegion(texture));}
    public StaticEntity(float x, float y, float z, AnimatedAsset asset){
        this(x,y,z,new TextureRegion(asset.defaultFrame()));
        animation = asset.defaultAnimation();
    }
    public StaticEntity(float x, float y, float z, Animation<TextureRegion> animation){
        this(x,y,z,animation.getKeyFrame(0));
        this.animation = animation;
    }
}
