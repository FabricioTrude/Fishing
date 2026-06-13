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

import static com.fabricio.fishing.features.GameContext.*;

public class Player extends Entity implements Holdable {
    protected Texture texture = FeatureAssets.PlayerTexture;
    protected Sprite sprite = new Sprite(texture);
    protected float width = sprite.getWidth();
    protected float height = sprite.getHeight();

    public static final FishingStats fishingStats = new FishingStats();

    private static EntityIndex[] indexes = {
        EntityIndex.PLAYER, EntityIndex.ENTITY, EntityIndex.CLICKABLE, EntityIndex.HOLDABLE
    };

    public Player(float x, float y) {
        super(x, y, indexes);
    }

    public static Player createPlayer(){
       return new Player(SCREEN_WIDTH /2-25, SEA_HEIGHT);
    }

    public void render(SpriteBatch batch) {
        float sx = x - width / 2;
        float sy = y - height / 2;
        sprite.setPosition(sx,sy);
        sprite.setOriginCenter();
        sprite.draw(batch);
    }

    @Override
    public Polygon getBounds() {
        Polygon poly = new Polygon(
            new float[]{
                0,0,
                width, 0,
                width, height,
                0, height
            }
        );
        poly.setOrigin(width /2, height /2);
        poly.setPosition(x - width / 2, y - height / 2);
        return poly;
    }

    boolean isHolding;
    @Override
    public void update(float delta){
        if(!isHolding) sprite.setScale(1);
    }

    @Override
    public void onClick() {
        sprite.setScale(0.8f);
    }

    @Override
    public void onHoldStart() {
        isHolding = true;
        sprite.setScale(1.2f);
    }

    @Override
    public void onHold() {
    }

    @Override
    public void onRelease() {
        isHolding = false;
    }
}
