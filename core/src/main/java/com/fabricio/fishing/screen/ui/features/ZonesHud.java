package com.fabricio.fishing.screen.ui.features;

import com.fabricio.fishing.entity.enums.Zones;
import com.fabricio.fishing.screen.ui.entries.ZoneEntry;
import com.fabricio.fishing.screen.ui.generics.MediumSizePanel;

public class ZonesHud extends MediumSizePanel {

    public ZonesHud() {
        super("Map");
        createZoneEntries();
        setVisible(false);
    }
    private void createZoneEntries(){
        float x = 20;
        float y = height - 120;
        for(Zones zone : Zones.values()){
            ZoneEntry entry = new ZoneEntry(zone);
            entry.setPosition(x,y);
            addActor(entry);
            y-=100;
        }
    }

}
