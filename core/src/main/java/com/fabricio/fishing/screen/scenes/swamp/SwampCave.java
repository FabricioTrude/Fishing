package com.fabricio.fishing.screen.scenes.swamp;

import com.fabricio.fishing.assets.enums.SFX;
import com.fabricio.fishing.assets.statics.BackgroundAssets;
import com.fabricio.fishing.assets.statics.WorldObjectAssets;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.entity.StaticEntity;
import com.fabricio.fishing.entity.statics.ClickableObjectEntity;
import com.fabricio.fishing.screen.scenes.generic.GenericCave;

import static com.fabricio.fishing.context.GlobalContext.*;

public class SwampCave extends GenericCave {
    public SwampCave() {
        new ClickableObjectEntity(SCREEN_WIDTH * 0.7f,SCREEN_HEIGHT * 0.55f, 10, WorldObjectAssets.CAVE_ENTRANCE)
            .setOnClick(() -> {dispose();
                C.ctx().setScene(new SwampPond(C.zone()));});
        new StaticEntity(0,0,-999, BackgroundAssets.SWAMP_CAVE_BACKGROUND);
        new StaticEntity(0,0,0, BackgroundAssets.SWAMP_CAVE_GROUND);
        new StaticEntity(0,0,200, BackgroundAssets.SWAMP_CAVE_FOREGROUND);
        G.sound().playMusic(SFX.SWAMP_CAVE, true);
    }
}
