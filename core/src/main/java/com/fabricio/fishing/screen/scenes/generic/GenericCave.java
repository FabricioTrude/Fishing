package com.fabricio.fishing.screen.scenes.generic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.data.PlayerData;
import com.fabricio.fishing.entity.ColorRectEntity;
import com.fabricio.fishing.entity.player.PlayerMiner;
import com.fabricio.fishing.features.mining.MiningFeature;
import com.fabricio.fishing.screen.LayeredScene;

import static com.fabricio.fishing.context.GlobalContext.*;

public class GenericCave extends LayeredScene {
    protected MiningFeature mining;
    protected SpriteBatch batch;

    public GenericCave() {
        mining = new MiningFeature();
        float floor_height = SCREEN_HEIGHT * 0.15f;
        PlayerData.setPlayer(new PlayerMiner(SCREEN_WIDTH * 0.5f, floor_height, 10,0.5f));
        C.CE().target(PlayerData.getPlayer());
        new ColorRectEntity(0,0, SCREEN_WIDTH, SCREEN_HEIGHT, Color.valueOf("1f1919"), -10000);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        mining.update(delta);
    }
}
