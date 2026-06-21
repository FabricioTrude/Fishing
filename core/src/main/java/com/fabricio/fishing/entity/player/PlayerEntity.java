package com.fabricio.fishing.entity.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.assets.statics.FeatureAssets;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.enums.EntityIndex;

public class PlayerEntity extends Entity {
    protected Texture texture = FeatureAssets.PlayerTexture;
    protected Sprite sprite = new Sprite(texture);
    protected Polygon poly;

    static EntityIndex[] indexes = {EntityIndex.PLAYER, EntityIndex.ENTITY};

    public PlayerEntity(float x, float y, float z) {
        super(x, y, z,indexes);
        width = sprite.getWidth();
        height = sprite.getHeight();
        sprite.setOriginCenter();
        poly = new Polygon(new float[]{0,0, width, 0, width, height, 0, height});
        poly.setOrigin(width /2, height /2);;
        setPosition(x,y,z);
    }
    public PlayerEntity(float x, float y, float z, float s) {this(x, y, z);setScale(s);}

    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }


    @Override
    public void update(float delta){
    }

    public void setScale(float s){
        sprite.setScale(s);
        poly.setScale(s,s);
    }

    public void setPosition(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
        float sx = x-width/2;
        float sy = y-height/2;
        sprite.setPosition(sx,sy);
        poly.setPosition(sx,sy);
    }

    public void setScene(float x, float y, float z, float s){
        setPosition(x,y,z);
        setScale(s);
    }
}
