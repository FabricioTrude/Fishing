package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.entity.player.Player;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.screen.FeatureScreen;
import com.fabricio.fishing.util.Palette;

import javax.naming.Context;
import java.util.EnumMap;

import static com.fabricio.fishing.features.GameContext.*;

public class FishingFeature implements FeatureScreen {
    private final GameContext context;
    private final FishManager fishManager;
    private final Player player;

    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private final SpriteBatch batch = new SpriteBatch();

        private final EnumMap<FishSpecies, Float> fishes = new EnumMap<>(FishSpecies.class);

    public FishingFeature(GameContext context) {
        this.context = context;
        player = context.getPlayer();
        fishManager = new FishManager(context, player.getFishingStatus());
        for(FishSpecies fish: FishSpecies.values()){
            fishes.put(fish, 0f);
        }
    }
    public void render(){
        update(Gdx.graphics.getDeltaTime());

        ScreenUtils.clear(
            context.getPaletteManager().getSkyColor()
        );

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Palette.SEA);
        shapeRenderer.rect(
            0,
            0,
            SCREEN_WIDTH,
            SEA_HEIGHT
        );
        shapeRenderer.end();

//        context.getEntityManager().renderBoxes(shapeRenderer);

        batch.begin();
        player.render(batch);
        fishManager.render(batch);
        batch.end();

    }

    public void update(float delta){
        context.getTimeManager().update(delta);
        player.update(delta);
        context.getPaletteManager().update();
        fishManager.update(delta);
        context.getClickManager().update();
        context.getEntityManager().flushRemovals();
    }

    @Override
    public void dispose() {

    }

    public void addFish(FishSpecies fish, float number){
        fishes.put(fish, fishes.get(fish) + number);
    }

    public float getFishes(FishSpecies fish) {
        return fishes.getOrDefault(fish,0f);
    }
}
