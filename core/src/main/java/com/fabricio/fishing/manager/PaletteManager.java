package com.fabricio.fishing.manager;

import com.badlogic.gdx.graphics.Color;
import com.fabricio.fishing.util.Palette;

public class PaletteManager extends TimeManager{
    TimeManager timeManager;
    protected Color skyColor;

    public PaletteManager(TimeManager timeManager) {
        this.timeManager = timeManager;
    }

    public void updateSkyColor(){
        switch(timeManager.getCurrentPeriod()){
            case DAWN -> skyColor = Palette.DAWN_SKY;
            case DAY -> skyColor = Palette.DAY_SKY;
            case SUNSET -> skyColor = Palette.SUNSET_SKY;
            case NIGHT -> skyColor = Palette.NIGHT_SKY;
            case MIDNIGHT -> skyColor = Palette.MIDNIGHT_SKY;
        };
    }

    public Color getSkyColor(){
        return skyColor;
    }

    public void update(){
        updateSkyColor();
    }
}
