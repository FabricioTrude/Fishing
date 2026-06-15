package com.fabricio.fishing.features.zones;

import com.fabricio.fishing.features.fishing.records.FishingZoneSwitchEvent;
import com.fabricio.fishing.screen.scenes.DefaultPond;
import com.fabricio.fishing.screen.scenes.swamp.SwampPond;

import static com.fabricio.fishing.features.GameContext.*;

public class ZoneManager {

    public ZoneManager() {
        eventBus.register(FishingZoneSwitchEvent .class, e -> setZoneScreen(e.zone()));
    }


    public void setZoneScreen(Zones zoneType) {
        switch (zoneType) {
            case Zones.SWAMP -> {
                getScene().dispose();
                setScene(new SwampPond());
            }
            default -> {
                getScene().dispose();
                setScene(new DefaultPond());
            }
        }
    }
}
