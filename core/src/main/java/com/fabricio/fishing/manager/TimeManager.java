package com.fabricio.fishing.manager;

import com.fabricio.fishing.entity.enums.TimePeriod;
import com.badlogic.gdx.graphics.Color;
import com.fabricio.fishing.util.Palette;

import java.time.LocalTime;

public class TimeManager {
    final boolean useRealTime = true;
    private TimePeriod currentPeriod;

    public TimeManager() {
        update();
    }

    public TimeManager(TimePeriod currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public void update(){
        if(!useRealTime) return;
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        switch (hour) {
            case 4,5,6,7 ->
                currentPeriod = TimePeriod.DAWN;
            case 8,9,10,11,12,13,14,15,16 ->
                currentPeriod = TimePeriod.DAY;
            case 17,18,19 ->
                currentPeriod = TimePeriod.SUNSET;
            case 20,21,22 ->
                currentPeriod = TimePeriod.NIGHT;
            default ->
                currentPeriod = TimePeriod.MIDNIGHT;
        }
    }

    public TimePeriod getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(TimePeriod currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public Color getSkyColor(){
        return switch(currentPeriod){
            case DAWN -> Palette.DAWN_SKY;
            case DAY -> Palette.DAY_SKY;
            case SUNSET -> Palette.SUNSET_SKY;
            case NIGHT -> Palette.NIGHT_SKY;
            case MIDNIGHT -> Palette.MIDNIGHT_SKY;
        };
    }
}
