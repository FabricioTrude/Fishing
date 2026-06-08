package com.fabricio.fishing.entity.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.entity.Frog;
import com.fabricio.fishing.entity.interfaces.Clickable;
import com.fabricio.fishing.entity.interfaces.Holdable;
import com.fabricio.fishing.event.Event;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.manager.EntityManager;
import com.fabricio.fishing.manager.TimeManager;

import static com.fabricio.fishing.screen.GameScreen.SCREEN_WIDTH;
import static com.fabricio.fishing.screen.GameScreen.SEA_HEIGHT;

public class Player extends Frog implements Holdable {

    protected TimeManager timeManager;
    protected EntityManager entityManager;

    protected Texture texture = new Texture("player/player.png");
    protected Sprite sprite = new Sprite(texture);
    protected float width = sprite.getWidth();
    protected float height = sprite.getHeight();

    public Player(float x, float y, TimeManager timeManager, EntityManager entityManager, EventBus eventBus) {
        super(x, y, eventBus);
        this.timeManager = timeManager;
        this.entityManager = entityManager;
        entityManager.addEntity(this);
    }

    public static Player createPlayer(TimeManager timeManager, EntityManager entityManager, EventBus eventBus){
       return new Player(SCREEN_WIDTH /2-25, SEA_HEIGHT, timeManager, entityManager, eventBus);
    }

    @Override
    public void update(float delta){

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

    boolean isHolding = false;
    boolean isFirstHold = true;

    @Override
    public boolean isFirstHold() {
        return isFirstHold;
    }

    @Override
    public boolean isHolding() {
        return isHolding;
    }

    @Override
    public void setFirstHold(boolean firstHold) {
        this.isFirstHold = firstHold;
    }

    @Override
    public void setHolding(boolean holding) {
        this.isHolding = holding;
    }

    @Override
    public void onClick() {
        System.out.println("Player clicked");
    }

    @Override
    public void onHold() {
        System.out.println("Player is holding");
        sprite.setScale(1.2f);
    }

    @Override
    public void onRelease() {
        System.out.println("Player released");
        sprite.setScale(1f);
    }
}
