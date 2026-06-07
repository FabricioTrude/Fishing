package com.fabricio.fishing.entity.fish;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.entity.enums.Zones;
import com.fabricio.fishing.entity.interfaces.Clickable;

import java.util.EnumSet;

import static com.badlogic.gdx.math.MathUtils.random;
import static com.fabricio.fishing.screen.GameScreen.SCREEN_WIDTH;
import static com.fabricio.fishing.screen.GameScreen.SEA_HEIGHT;

public class Fish extends Entity implements Clickable {
    protected FishSpecies species;
    protected FishRarity rarity;
    protected FishSize size;

    protected Zones zone;
    protected EnumSet<TimePeriod> periods;
    protected float fishHP;
    protected float fishDEF;
    protected float fishVAL;
    protected float fishSPE;
    protected float fishSIZ;
    protected Sprite sprite;
    protected float targetX;
    protected float targetY;
    protected float tick = 0;
    protected FishState state;
    protected float rotation;


    // TODO Fish
    //1. Peixes nadam ✅
    //2. Peixes param para descansar
    //3. Peixes saem da tela e são removidos
    //4. Novos peixes spawnam
    //5. Toque detecta peixe
    //6. HP / Defesa
    //7. Animação de pesca
    //8. Economia

    public Fish(float x, float y) {
        super(x, y);
        this.species = FishSpecies.BASS;
        this.rarity = FishRarity.random();
        this.size = FishSize.random();
        this.zone = species.getZone();
        this.periods = species.getPeriods();
        this.fishHP = species.getBaseHP();
        this.fishDEF = species.getBaseDEF();
        this.fishVAL = species.getBaseVAL();
        this.fishSPE = species.getBaseSPE();
        this.fishSIZ = size.getScale();
        this.sprite = new Sprite(species.getTexture());
        this.width = 100 * fishSIZ;
        this.height = 50 * fishSIZ;
        this.sprite.setSize(this.width, this.height);
        pickTarget();
    }

    @Override
    public void update(float delta) {
        switch(state){
            case FishState.SWIMMING -> {
                float dx = targetX - x;
                float dy = targetY - y;
                rotation = MathUtils.atan2(dy, dx) * MathUtils.radiansToDegrees;
                float distance = (float)Math.sqrt(
                    dx * dx + dy * dy
                );
                if (distance <= 0.1f) state = FishState.IDLE;
                x += dx / distance * fishSPE * delta;
                y += dy / distance * fishSPE * delta;
            }
            case FishState.IDLE -> {
                tick += delta;
                if(tick >= 1) pickTarget();
            }
        }
    }

    public void render(SpriteBatch batch) {

        sprite.setPosition(x - width / 2 , y - height / 2);
        sprite.setOriginCenter();
        sprite.setRotation(rotation);
        sprite.draw(
            batch
        );
    }
    public Polygon getBounds(){
        Polygon poly = new Polygon(
            new float[]{
                0, 0,
                width, 0,
                width, height,
                0 ,height
            }
        );
        poly.setOrigin(width / 2, height / 2);
        poly.setPosition(x - width / 2, y - height / 2);
        poly.rotate(rotation);
        return poly;
    }

    public static Fish spawn(){
        return new Fish(
            -30,
            random.nextFloat() * SEA_HEIGHT
        );
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

    @Override
    public void onClick() {
        fishHP--;
    }
}
