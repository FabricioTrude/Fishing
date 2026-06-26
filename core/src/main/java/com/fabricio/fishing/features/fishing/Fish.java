package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.entity.MobileEntity;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.entity.enums.EntityState;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.event.input.Clickable;
import com.fabricio.fishing.features.fishing.records.FishCaughtEvent;
import com.fabricio.fishing.features.fishing.records.FishClickedEvent;
import com.fabricio.fishing.features.fishing.enums.*;

import java.util.EnumSet;

import static com.fabricio.fishing.context.GlobalContext.*;
import static com.fabricio.fishing.screen.scenes.generic.GenericPond.SEA_HEIGHT;

public class Fish extends MobileEntity implements Clickable {
    protected FishSpecies species;
    protected FishRarity rarity;
    protected FishSize size;
    protected EnumSet<TimePeriod> periods;

    private static final EntityIndex[] indexes = {EntityIndex.FISH, EntityIndex.CLICKABLE, EntityIndex.ENTITY};

    protected float fishHP;
    protected float fishDEF;
    protected float fishSTAM;
    protected float bSTAM;

    protected float tick = 0;
    protected float panicTick = 0;
    protected float restingTime;

    protected Polygon polygon;

    // TODO Fish
    //1. Peixes nadam ✅
    //2. Peixes param para descansar ✅
    //3. Peixes saem da tela e são removidos
    //4. Novos peixes spawnam ✅
    //5. Toque detecta peixe ✅
    //6. HP / Defesa
    //7. Animação de pesca
    //8. Economia

    public Fish(float x, float y, FishSpecies species) {
        super(x, y, -10, species.getTexture(), indexes);
        this.species = species;
        rarity = FishRarity.random();
        size = FishSize.random();
        periods = species.getPeriods();
        fishHP = species.getBaseHP();
        fishDEF = species.getBaseDEF();
        speed = species.getBaseSPE();
        bSTAM = species.getBaseSTAM();
        setSize(sprite.getWidth(), sprite.getHeight());
        setScale(size.getScale());
        initPolygon();
        pickTarget();
        centered = true;
    }

    private void initPolygon(){
        this.polygon = new Polygon(
            new float[]{
                -width/2f, -height/2f,
                width/2f, -height/2f,
                width/2f, height/2f,
                -width/2f, height/2f
            }
        );
        polygon.setScale(getScale(), getScale());
    }

    @Override
    public void update(float delta) {
        rotation = MathUtils.atan2(dY(), dX()) * MathUtils.radiansToDegrees;
        float distance = (float)Math.sqrt(dX() * dX() + dY() * dY());
        if (distance <= 1f) state = EntityState.IDLE;

        switch(state){
            case EntityState.WALKING -> {
                pos.x += dX() / distance * speed * delta;
                pos.y += dY() / distance * speed * delta;
                fishSTAM -= delta;
                if(fishSTAM <= 0) {
                    restingTime = MathUtils.random(2, bSTAM/2);
                    state = EntityState.RESTING;
                }
            }
            case EntityState.PANIC -> {
                pos.x += dX() / distance * speed * delta * 1.5f;
                pos.y += dY() / distance * speed * delta * 1.5f;
                fishSTAM -= delta * 1.5f;
                if(panicTick >=5 ) {
                    state = EntityState.RESTING;
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
                if(tick >= 1) pickTarget();
            }
        }
        polygon.setPosition(pos.x, pos.y);
        polygon.setRotation(rotation);
        if(!alive()) G.ebus().post(new FishCaughtEvent(this, getScale()));
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

    public Polygon getBounds(){
        return polygon;
    }

    public void pickTarget(){
        setTarget(MathUtils.random(-20, SCREEN_WIDTH + 20),
            MathUtils.random(-20, SEA_HEIGHT -20));
        state = EntityState.WALKING;
        tick = 0;
    }

    public boolean alive(){
        return fishHP > 0;
    }
    public FishSpecies getSpecies(){
        return species;
    }

    @Override
    public void onClick() {
        if(alive() && state != EntityState.PANIC) {
            pickTarget();
            state = EntityState.PANIC;
        }
        G.ebus().post(new FishClickedEvent(this));
        fishHP--;
    }
}
