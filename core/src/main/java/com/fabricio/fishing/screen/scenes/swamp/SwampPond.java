package com.fabricio.fishing.screen.scenes.swamp;

import com.fabricio.fishing.assets.statics.BackgroundAssets;
import com.fabricio.fishing.assets.statics.WorldObjectAssets;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.entity.input.ClickableObjectEntity;
import com.fabricio.fishing.entity.SpriteEntity;
import com.fabricio.fishing.features.zones.Zones;
import com.fabricio.fishing.screen.scenes.generic.GenericPond;

import static com.fabricio.fishing.context.GlobalContext.*;

public class SwampPond extends GenericPond {

    public SwampPond(Zones zone) {
        super(zone);
        new SpriteEntity(BackgroundAssets.SWAMP_POND_BACKGROUND, -1000);
        new SpriteEntity(BackgroundAssets.SWAMP_POND_GROUND, 0);
        new ClickableObjectEntity(SCREEN_WIDTH * 0.05f,SCREEN_HEIGHT * 0.6f, 2,WorldObjectAssets.CAVE_ENTRANCE)
            .setOnClick(() -> {dispose();C.ctx().setScene(new SwampCave());});
    }
}
