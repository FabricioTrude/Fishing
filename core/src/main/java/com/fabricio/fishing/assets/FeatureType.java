package com.fabricio.fishing.assets;

import com.fabricio.fishing.assets.enums.AtlasId;
import com.fabricio.fishing.assets.statics.FeatureAssets;
import com.fabricio.fishing.features.zones.Zones;

public interface FeatureType {
    String id();
    AtlasId atlas();
    Zones zone();
    default AnimatedAsset texture(){
        return FeatureAssets.get(this);
    }
}
