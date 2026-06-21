package com.fabricio.fishing.screen.scenes.swamp;

import com.fabricio.fishing.assets.statics.BackgroundAssets;
import com.fabricio.fishing.assets.statics.WorldObjectAssets;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.entity.input.ClickableObjectEntity;
import com.fabricio.fishing.entity.SpriteEntity;
import com.fabricio.fishing.screen.scenes.generic.GenericCave;

import static com.fabricio.fishing.context.GlobalContext.*;

public class SwampCave extends GenericCave {
    public SwampCave() {
        new ClickableObjectEntity(SCREEN_WIDTH * 0.7f,SCREEN_HEIGHT * 0.55f, 10, WorldObjectAssets.CAVE_ENTRANCE)
            .setOnClick(() -> {dispose();
                C.ctx().setScene(new SwampPond(C.zone()));});
        new SpriteEntity(BackgroundAssets.SWAMP_CAVE_BACKGROUND, -999);
        new SpriteEntity(BackgroundAssets.SWAMP_CAVE_GROUND, 0);
        new SpriteEntity(BackgroundAssets.SWAMP_CAVE_FOREGROUND, 200);
    }
}
