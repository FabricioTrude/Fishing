package com.fabricio.fishing.screen.scenes.swamp;

import com.fabricio.fishing.assets.statics.BackgroundAssets;
import com.fabricio.fishing.assets.statics.WorldObjectAssets;
import com.fabricio.fishing.entity.ClickableObjectEntity;
import com.fabricio.fishing.entity.SpriteEntity;
import com.fabricio.fishing.screen.RenderLayer;
import com.fabricio.fishing.screen.scenes.DefaultPond;

import static com.fabricio.fishing.features.GameContext.*;

public class SwampPond extends DefaultPond {

    public SwampPond() {
        super();
        new SpriteEntity(BackgroundAssets.SWAMP_BACKGROUND, RenderLayer.BACKGROUND);
        new SpriteEntity(BackgroundAssets.SWAMP_FOREGROUND, RenderLayer.FOREGROUND);
        new ClickableObjectEntity(SCREEN_WIDTH * 0.05f,SCREEN_HEIGHT * 0.55f, WorldObjectAssets.CAVE_ENTRANCE, RenderLayer.OVERLAY);
    }
}
