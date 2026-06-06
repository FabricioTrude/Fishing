package com.fabricio.fishing.manager;

import com.fabricio.fishing.entity.enums.TimePeriod;

import java.time.LocalTime;

public class TimeManager {
    protected final boolean useRealTime = true;
    protected float tick = 20;
    protected float time;
    protected LocalTime realTime = LocalTime.now();
    protected TimePeriod currentPeriod;

    public TimeManager() {
        this.currentPeriod = TimePeriod.DAY;
    }

    public void update(float delta){
        this.time += delta;
        realTime = LocalTime.now();
        if(useRealTime)updateCurrentPeriod();
    }

    public void updateCurrentPeriod(){
        int hour = realTime.getHour();
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
}
