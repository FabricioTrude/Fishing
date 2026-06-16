package com.fabricio.fishing.screen.scenes.swamp;

import com.fabricio.fishing.assets.statics.BackgroundAssets;
import com.fabricio.fishing.assets.statics.WorldObjectAssets;
import com.fabricio.fishing.entity.ClickableObjectEntity;
import com.fabricio.fishing.entity.SpriteEntity;
import com.fabricio.fishing.screen.RenderLayer;
import com.fabricio.fishing.screen.scenes.generic.GenericPond;

import static com.fabricio.fishing.features.GameContext.*;

public class SwampPond extends GenericPond {

    public SwampPond() {
        super();
        new SpriteEntity(BackgroundAssets.SWAMP_POND_BACKGROUND, -1000);
        new SpriteEntity(BackgroundAssets.SWAMP_POND_GROUND, 0);
        new ClickableObjectEntity(SCREEN_WIDTH * 0.05f,SCREEN_HEIGHT * 0.6f, 2,WorldObjectAssets.CAVE_ENTRANCE)
            .setOnClick(() -> {dispose();setScene(new SwampCave());});
    }
}
