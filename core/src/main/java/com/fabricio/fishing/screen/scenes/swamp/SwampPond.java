package com.fabricio.fishing.screen.scenes.swamp;

import com.fabricio.fishing.assets.enums.SFX;
import com.fabricio.fishing.assets.statics.BackgroundAssets;
import com.fabricio.fishing.assets.statics.WorldObjectAssets;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.entity.StaticEntity;
import com.fabricio.fishing.entity.statics.ClickableObjectEntity;
import com.fabricio.fishing.features.zones.Zones;
import com.fabricio.fishing.screen.scenes.generic.GenericPond;

import static com.fabricio.fishing.context.GlobalContext.SCREEN_HEIGHT;
import static com.fabricio.fishing.context.GlobalContext.SCREEN_WIDTH;

public class SwampPond extends GenericPond {

    public SwampPond(Zones zone) {
        super(zone);
        new StaticEntity(0,0,-1000,BackgroundAssets.SWAMP_POND_BACKGROUND);
        new StaticEntity(0,0,0,BackgroundAssets.SWAMP_POND_GROUND);
        new ClickableObjectEntity(SCREEN_WIDTH * 0.05f,SCREEN_HEIGHT * 0.6f, 2,WorldObjectAssets.CAVE_ENTRANCE)
            .setOnClick(() -> {dispose();C.ctx().setScene(new SwampCave());});
        G.sound().playMusic(SFX.SWAMP_POND, true);
    }
}
