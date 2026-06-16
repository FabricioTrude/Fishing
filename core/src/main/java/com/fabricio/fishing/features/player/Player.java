package com.fabricio.fishing.features.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.assets.statics.FeatureAssets;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.entity.interfaces.Holdable;
import com.fabricio.fishing.features.player.stats.FishingStats;
import com.fabricio.fishing.screen.RenderLayer;

public class Player extends Entity implements Holdable {
    protected Texture texture = FeatureAssets.PlayerTexture;
    protected Sprite sprite = new Sprite(texture);
    protected float width = sprite.getWidth();
    protected float height = sprite.getHeight();

    public static final FishingStats fishingStats = new FishingStats();

    static EntityIndex[] indexes = {
        EntityIndex.PLAYER, EntityIndex.ENTITY, EntityIndex.CLICKABLE, EntityIndex.HOLDABLE, EntityIndex.NOT_REMOVE
    };

    public Player() {
        super(0,0, 10,indexes);
        poly.setOrigin(width /2, height /2);
        sprite.setOriginCenter();
    }

    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    protected Polygon poly = new Polygon(
        new float[]{
            0,0,
            width, 0,
            width, height,
            0, height
        }
    );

    @Override
    public Polygon getBounds() {
        return poly;
    }

    @Override
    public void update(float delta){
    }

    @Override
    public void onClick() {
    }

    @Override
    public void onHoldStart() {
        sprite.setScale(sprite.getScaleX() * 1.1f);
        poly.setScale(poly.getScaleX() * 1.1f, poly.getScaleY() * 1.1f);
    }

    @Override
    public void onHold() {
    }

    @Override
    public void onRelease() {
        sprite.setScale(sprite.getScaleX() * 0.9f);
        poly.setScale(poly.getScaleX() * 0.9f, poly.getScaleY() * 0.9f);
    }

    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }

    public void setScale(float s){
        sprite.setScale(s);
        poly.setScale(s,s);
    }

    public void setPosition(float x, float y, float z){
        float sx = x-width/2;
        float sy = y-height/2;
        this.x = sx;
        this.y = sy;
        this.z = z;
        sprite.setPosition(sx,sy);
        poly.setPosition(sx,sy);
    }

    public void setScene(float x, float y, float z, float s){
        setPosition(x,y,z);
        setScale(s);
    }
}
