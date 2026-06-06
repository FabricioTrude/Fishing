package com.fabricio.fishing.entity.fish;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.entity.enums.Zones;

import java.util.EnumSet;

import static com.badlogic.gdx.math.MathUtils.random;
import static com.fabricio.fishing.screen.GameScreen.seaHeight;

public class Fish extends Entity {
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

    protected ShapeRenderer shapeRenderer = new ShapeRenderer();

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
        this.fishSIZ = species.getBaseSIZ() * size.getScale();
    }

    @Override
    public void update(float delta) {
        x += (float) (fishSPE * delta);
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.BROWN);
        shapeRenderer.circle(
            x,
            y,
            fishSIZ
        );
    }

    public static Fish spawn(){
        return new Fish(
            -30,
            random.nextFloat() * seaHeight
        );
    }
}
