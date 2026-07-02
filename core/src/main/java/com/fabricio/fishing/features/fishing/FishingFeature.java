package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.event.annotations.Subscribe;
import com.fabricio.fishing.event.records.GroundClickEvent;
import com.fabricio.fishing.features.fishing.enums.FishSpecies;
import com.fabricio.fishing.data.FishingData;

import static com.badlogic.gdx.math.MathUtils.random;
import static com.fabricio.fishing.context.GlobalContext.*;
import static com.fabricio.fishing.screen.scenes.generic.GenericPond.SEA_HEIGHT;

public class FishingFeature {
    static FishingData fishing = new FishingData();

    float spawnTimer = 0;

    public FishingFeature() {
        G.ebus().register(this);
    }

    public void createFish(){
        FishSpecies species = FishSpecies.random(C.zone());
        if(species == null) return;
        float direction = MathUtils.random(1f);
        float rX = MathUtils.random(50f);
        rX = direction >= 0.5f ? rX - 50 : rX + SCREEN_WIDTH;
        C.entities().register(new Fish(
            rX,
            random.nextFloat() * SEA_HEIGHT,
            species
        ));
        fishing.setCurrentFishes(fishing.getCurrentFishes() + 1);
    }

    public void update(float delta){
        spawnTimer += delta;
        if(spawnTimer > fishing.getFishingRespawnTime() &&
            fishing.getCurrentFishes() < fishing.getMaxFishes()){
            spawnTimer = 0;
            createFish();
        }
    }

    @Subscribe
    public void onGroundClick(GroundClickEvent e){
        C.CE().target(null);
        C.CE().resetZoom();
    }

    public void dispose(){
        fishing.setCurrentFishes(0);
        G.ebus().unregister(this);
    }
}
