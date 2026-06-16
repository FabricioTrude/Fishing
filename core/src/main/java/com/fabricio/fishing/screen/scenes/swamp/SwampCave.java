package com.fabricio.fishing.screen.scenes.swamp;

import com.fabricio.fishing.assets.statics.WorldObjectAssets;
import com.fabricio.fishing.entity.ClickableObjectEntity;
import com.fabricio.fishing.screen.RenderLayer;
import com.fabricio.fishing.screen.scenes.generic.GenericCave;

import static com.fabricio.fishing.features.GameContext.*;

public class SwampCave extends GenericCave {
    public SwampCave() {
        new ClickableObjectEntity(SCREEN_WIDTH * 0.85f,SCREEN_HEIGHT * 0.55f, WorldObjectAssets.CAVE_ENTRANCE, RenderLayer.OVERLAY)
            .setOnClick(() -> {
                dispose();
                setScene(new SwampPond());
            });
    }
}
