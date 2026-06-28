package com.fabricio.fishing.features.mining.enums;

import com.fabricio.fishing.assets.FeatureType;
import com.fabricio.fishing.assets.enums.AtlasId;
import com.fabricio.fishing.assets.AnimatedAsset;
import com.fabricio.fishing.features.Feature;
import com.fabricio.fishing.features.zones.Zones;

import java.util.Locale;

public enum Ores implements FeatureType {
    SWAMP_STONE("Swamp Stone", "rocks_rock", Zones.SWAMP),
    SWAMP_COPPER("Swamp Copper", "ores_copper", Zones.SWAMP),
    SWAMP_OPAL("Swamp Opal", "gems_opal", Zones.SWAMP);

    private final String name;
    private final String assetId;
    private final Zones zone;

    Ores(String name, String assetId,Zones zone) {
        this.name = name;
        this.zone = zone;
        this.assetId = assetId;
    }
    public String display(){return name;}

    @Override
    public Zones zone(){
        return zone;
    }
    @Override
    public String id() {
        return assetId;
    }
    @Override
    public AtlasId atlas() {
        return zone.atlas(Feature.MINING);
    }
    @Override
    public AnimatedAsset texture() {
        return FeatureType.super.texture();
    }
}
