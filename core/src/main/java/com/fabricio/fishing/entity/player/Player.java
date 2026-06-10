package com.fabricio.fishing.entity.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.entity.Frog;
import com.fabricio.fishing.entity.interfaces.Holdable;
import com.fabricio.fishing.features.fishing.FishingStatus;
import com.fabricio.fishing.entity.EntityManager;
import com.fabricio.fishing.manager.TimeManager;

import static com.fabricio.fishing.features.GameContext.*;

public class Player extends Frog implements Holdable {
    protected TimeManager timeManager;
    protected EntityManager entityManager;

    protected Texture texture = new Texture("player/player.png");
    protected Sprite sprite = new Sprite(texture);
    protected float width = sprite.getWidth();
    protected float height = sprite.getHeight();

    private final FishingStatus fishingStatus = new FishingStatus();

    public FishingStatus getFishingStatus(){
        return fishingStatus;
    }

    public Player(float x, float y, TimeManager timeManager, EntityManager entityManager) {
        super(x, y);
        this.timeManager = timeManager;
        this.entityManager = entityManager;
        entityManager.addEntity(this);
    }

    public static Player createPlayer(TimeManager timeManager, EntityManager entityManager){
       return new Player(SCREEN_WIDTH /2-25, SEA_HEIGHT, timeManager, entityManager);
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
