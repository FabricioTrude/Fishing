package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.entity.interfaces.Clickable;
import com.fabricio.fishing.features.fishing.records.FishCaughtEvent;
import com.fabricio.fishing.features.fishing.records.FishClickedEvent;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.features.fishing.enums.*;
import com.fabricio.fishing.features.zones.Zones;
import com.fabricio.fishing.screen.RenderLayer;

import java.util.EnumSet;

import static com.fabricio.fishing.features.GameContext.*;
import static com.fabricio.fishing.screen.scenes.generic.GenericPond.SEA_HEIGHT;

public class Fish extends Entity implements Clickable {
    protected FishSpecies species;
    protected FishRarity rarity;
    protected FishSize size;
    protected Zones zone;
    protected EnumSet<TimePeriod> periods;

    private static final EntityIndex[] indexes = {EntityIndex.FISH, EntityIndex.ENTITY, EntityIndex.CLICKABLE};

    protected float fishHP;
    protected float fishDEF;
    protected float fishVAL;
    protected float fishSPE;
    protected float fishSIZ;
    protected float fishSTAM;
    protected float bSTAM;
    protected FishState state;
    protected float tick = 0;
    protected float panicTick = 0;
    protected float restingTime;

    protected Sprite sprite;
    protected Polygon polygon;
    protected boolean flipped;
    protected float targetX;
    protected float targetY;
    protected float rotation;


    // TODO Fish
    //1. Peixes nadam ✅
    //2. Peixes param para descansar
    //3. Peixes saem da tela e são removidos
    //4. Novos peixes spawnam ✅
    //5. Toque detecta peixe ✅
    //6. HP / Defesa
    //7. Animação de pesca
    //8. Economia

    public Fish(float x, float y, FishSpecies species) {
        super(x, y, RenderLayer.ENTITY,indexes);
        this.species = species;
        this.rarity = FishRarity.random();
        this.size = FishSize.random();
        this.periods = species.getPeriods();
        this.fishHP = species.getBaseHP();
        this.fishDEF = species.getBaseDEF();
        this.fishVAL = species.getBaseVAL();
        this.fishSPE = species.getBaseSPE();
        this.fishSIZ = size.getScale() * species.getBaseSIZ();
        this.bSTAM = species.getBaseSTAM();
        this.sprite = new Sprite(species.getTexture());
        this.width = sprite.getWidth() * fishSIZ;
        this.height = sprite.getHeight() * fishSIZ;
        this.sprite.setSize(this.width, this.height);
        initPolygon();
        pickTarget();
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
    }

    public void render(SpriteBatch batch) {
        float sx = x-width/2;
        float sy = y-height/2;
        sprite.setPosition(sx , sy);
        sprite.setOriginCenter();
        boolean leftSide = rotation > 90 || rotation < -90;
        if(leftSide) {
            if(!flipped) {
                sprite.flip(true, false);
                flipped = true;
            }
            sprite.setRotation(rotation - 180);
        } else {
            if(flipped) {
                sprite.flip(true, false);
                flipped = false;
            }
            sprite.setRotation(rotation);
        }
        sprite.draw(batch);
    }

    @Override
    public void update(float delta) {
        float dx = targetX - x;
        float dy = targetY - y;
        rotation = MathUtils.atan2(dy, dx) * MathUtils.radiansToDegrees;
        float distance = (float)Math.sqrt(dx * dx + dy * dy);
        if (distance <= 1f) state = FishState.IDLE;

        switch(state){
            case FishState.SWIMMING -> {
                x += dx / distance * fishSPE * delta;
                y += dy / distance * fishSPE * delta;
                fishSTAM -= delta;
                if(fishSTAM <= 0) {
                    restingTime = MathUtils.random(2, bSTAM/2);
                    state = FishState.RESTING;
                }
            }
            case FishState.PANIC -> {
                x += dx / distance * fishSPE * delta * 1.5f;
                y += dy / distance * fishSPE * delta * 1.5f;
                fishSTAM -= delta * 1.5f;
                if(panicTick >=5 ) {
                    state = FishState.RESTING;
                    panicTick = 0;
                }
            }
            case FishState.RESTING -> {
                restingTime -= delta;
                if(restingTime <= 0){
                    fishSTAM = bSTAM;
                    state = FishState.SWIMMING;
                }
            }
            case FishState.IDLE -> {
                tick += delta;
                if(tick >= 1) pickTarget();
            }
        }
        polygon.setPosition(x, y);
        polygon.setRotation(rotation);

        if(!alive()) eventBus.post(new FishCaughtEvent(this, getFishVAL()));
    }

    public Polygon getBounds(){
        return polygon;
    }

    public void pickTarget(){
        targetX = MathUtils.random(
          -20, SCREEN_WIDTH + 20
        );
        targetY = MathUtils.random(
          -20, SEA_HEIGHT -20
        );
        state = FishState.SWIMMING;
        tick = 0;
    }

    public boolean alive(){
        return fishHP > 0;
    }

    public float getFishVAL(){
        return fishVAL * size.getScale();
    }
    public FishSpecies getSpecies(){
        return species;
    }
    public float getFishSIZ() {
        return fishSIZ;
    }

    @Override
    public void onClick() {
        if(alive() && state != FishState.PANIC) {
            pickTarget();
            state = FishState.PANIC;
        }
        GameContext.eventBus.post(new FishClickedEvent(this));
        fishHP--;
    }
}
