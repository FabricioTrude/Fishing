package com.fabricio.fishing.assets.enums;

import java.util.Locale;

public enum AtlasId {
//    FISHING_LEGACY;
    FISHING_SWAMP,
    FISHING_OASIS,
    MINING_SWAMP;

    public String path() {
        return "atlas/%s.atlas"
            .formatted(name().toLowerCase(Locale.ROOT));
    }
}
