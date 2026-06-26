package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StaticEntity extends SpriteEntity{
    public StaticEntity(float x, float y, float z, TextureRegion texture) {
        super(x, y, z, texture);
        centered = false;
    } public StaticEntity(float x, float y, float z, Texture texture){this(x,y,z,new TextureRegion(texture));}
}
