package com.fabricio.fishing.screen.scenes.generic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.data.PlayerData;
import com.fabricio.fishing.entity.statics.ColorRectEntity;
import com.fabricio.fishing.features.player.PlayerEntity;
import com.fabricio.fishing.features.zones.Zones;
import com.fabricio.fishing.screen.LayeredScene;
import com.fabricio.fishing.features.fishing.FishingFeature;

import static com.fabricio.fishing.context.GlobalContext.*;

public class GenericPond extends LayeredScene {

    protected FishingFeature fishing;
    protected SpriteBatch batch;
    public static float SEA_HEIGHT = SCREEN_HEIGHT * 0.5f;

    public GenericPond(Zones zone) {
        fishing = new FishingFeature();
        float sea_height = zone.getSea_height();
        setSeaHeight(sea_height);
        PlayerData.setPlayer(new PlayerEntity(SCREEN_WIDTH/2, sea_height, 10));
        ColorRectEntity sky = new ColorRectEntity(0,0, SCREEN_WIDTH, SCREEN_HEIGHT, G.time().getSkyColor(), -10000);
        sky.setUpdate(() -> sky.setColor(G.time().getSkyColor()));
        new ColorRectEntity(0,0, SCREEN_WIDTH, SEA_HEIGHT, zone.color(), -20);
    }

    public static void setSeaHeight(float seaHeight) {
        SEA_HEIGHT = seaHeight;
    }

    @Override
    public void update(float delta) {
        fishing.update(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
        fishing.dispose();
    }
}
