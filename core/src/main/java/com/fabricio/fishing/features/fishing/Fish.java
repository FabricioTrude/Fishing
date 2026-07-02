package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.entity.MobileEntity;
import com.fabricio.fishing.entity.components.ClickableComponent;
import com.fabricio.fishing.entity.components.HealthComponent;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.entity.enums.EntityState;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.event.input.Clickable;
import com.fabricio.fishing.event.records.GroundClickEvent;
import com.fabricio.fishing.features.fishing.enums.FishRarity;
import com.fabricio.fishing.features.fishing.enums.FishSize;
import com.fabricio.fishing.features.fishing.enums.FishSpecies;
import com.fabricio.fishing.features.fishing.records.FishCaughtEvent;
import com.fabricio.fishing.features.fishing.records.FishClickedEvent;

import java.util.EnumSet;

import static com.fabricio.fishing.context.GlobalContext.SCREEN_WIDTH;
import static com.fabricio.fishing.screen.scenes.generic.GenericPond.SEA_HEIGHT;

public class Fish extends MobileEntity {
    protected FishSpecies species;
    protected FishRarity rarity = FishRarity.random();
    protected FishSize size = FishSize.random();
    protected EnumSet<TimePeriod> periods;

    private static final EntityIndex[] indexes = {EntityIndex.FISH, EntityIndex.CLICKABLE, EntityIndex.ENTITY};

    protected HealthComponent health;
    protected float fishSTAM;
    protected float bSTAM;

    protected float tick = 0;
    protected float panicTick = 0;
    protected float restingTime;

    // TODO Fish
    //3. Peixes saem da tela e são removidos
    //6. HP / Defesa
    //7. Animação de pesca

    public Fish(float x, float y, FishSpecies species) {
        super(x, y, -10, species.texture());
        addCategories(indexes);
        this.species = species;
        periods = species.periods();
        movement.setSpeed(species.SPE());
        bSTAM = species.SIZ();
        setSize(sprite.getWidth() * species.SIZ(), sprite.getHeight() * species.SIZ());
        setScale(size.getScale());
        pickTarget();
        centered = true;
        health = new HealthComponent(species.HP(), species.DEF());
        ClickableComponent clickable = new ClickableComponent(
            this,
            ClickableComponent.createCenteredPolygon(width, height),
            this::click);
        clickable.setScale(getScale());
        addComponent(health, clickable);
    }
    @Override
    public void update(float delta) {
        rotation = MathUtils.atan2(movement.dY(), movement.dX()) * MathUtils.radiansToDegrees;
        float distance = movement.dist();
        if (distance <= 0.1f) state = EntityState.IDLE;
        switch(state){
            case EntityState.WALKING -> {
                fishSTAM -= delta;
                if(fishSTAM <= 0) {
                    restingTime = MathUtils.random(2, bSTAM/2);
                    state = EntityState.RESTING;
                }
            }
            case EntityState.PANIC -> {
                fishSTAM -= delta * 1.5f;
                if(panicTick >= 5 ) {
                    state = EntityState.RESTING;
                    movement.setSpeedModifier(1);
                    panicTick = 0;
                }
            }
            case EntityState.RESTING -> {
                restingTime -= delta;
                if(restingTime <= 0){
                    fishSTAM = bSTAM;
                    state = EntityState.WALKING;
                }
            }
            case EntityState.IDLE -> {
                tick += delta;
                if(tick >= MathUtils.random(0.5f,3f)) pickTarget();
            }
        }
        if(health.isDead()) G.ebus().post(new FishCaughtEvent(this, getScale()));
        super.update(delta);
    }

    @Override
    public void render(SpriteBatch batch) {
        boolean leftSide = rotation > 90 || rotation < -90;
        if(leftSide) {
            if(!flipped) {
                sprite.flip(true, false);
                flipped = true;
            }
            setRotation(rotation - 180);
        } else {
            if(flipped) {
                sprite.flip(true, false);
                flipped = false;
            }
            setRotation(rotation);
        }
        super.render(batch);
    }

    public void pickTarget(){
        setTarget(MathUtils.random(-20, SCREEN_WIDTH + 20),
            MathUtils.random(-20, SEA_HEIGHT -20));
        state = EntityState.WALKING;
        tick = 0;
    }

    public FishSpecies getSpecies(){
        return species;
    }

    public void click() {
        if(state != EntityState.PANIC) {
            pickTarget();
            state = EntityState.PANIC;
            movement.setSpeedModifier(1.5f);
        }
        health.damage(1);
        if(health.isAlive()){
            G.ebus().post(new FishClickedEvent(this));
            C.CE().zoomIn(1.3f);
            C.CE().target(this);
        } else {
            G.ebus().post(new GroundClickEvent(pos.x,pos.y));
        }
    }
}
