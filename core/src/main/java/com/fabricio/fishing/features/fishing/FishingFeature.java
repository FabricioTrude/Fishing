package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.features.fishing.enums.FishingZones;
import com.fabricio.fishing.features.player.Player;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.screen.FeatureScreen;

import static com.fabricio.fishing.features.GameContext.*;

public class FishingFeature implements FeatureScreen {
    private final GameContext context;
    private final FishManager fishManager;
    private final Player player;

    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private final SpriteBatch batch = new SpriteBatch();

    private FishingZones zone;

    public FishingFeature(GameContext context) {
        this.context = context;
        zone = FishingZones.SWAMP;
        player = context.getPlayer();
        fishManager = new FishManager(context, player.getFishingStatus());
    }
    public void render(){
        update(Gdx.graphics.getDeltaTime());
        ScreenUtils.clear(context.getTimeManager().getSkyColor());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        assert GameContext.getContext().getFishingFeature() != null;
        shapeRenderer.setColor(GameContext.getContext().getFishingFeature().getZone().getColor());
        shapeRenderer.rect(
            0,
            0,
            SCREEN_WIDTH,
            SEA_HEIGHT
        );
        shapeRenderer.end();

//        context.getEntityManager().renderBoxes(shapeRenderer);
        batch.begin();
        fishManager.render(batch);
        player.render(batch);
        batch.end();

    }

    public void update(float delta){
        context.getTimeManager().update(delta);
        player.update(delta);
        fishManager.update(delta);
        context.getClickManager().update();
        context.getEntityManager().flushRemovals();
    }

    @Override
    public void dispose() {

    }

    public FishingZones getZone() {
        return zone;
    }

    public void setZone(FishingZones zone) {
        this.zone = zone;
    }
}
