package com.fabricio.fishing.manager;

import com.badlogic.gdx.graphics.Color;
import com.fabricio.fishing.entity.enums.TimePeriod;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.manager.records.TickEvent;

import java.time.LocalTime;

public class TimeManager {
    protected final boolean useRealTime = false;
    protected float tick = 10; // velocidade que as horas passam
    protected float gameMinutes = 0f;
    protected LocalTime realTime = LocalTime.now();
    protected TimePeriod currentPeriod;

    EventBus ebus;

    public TimeManager(EventBus ebus) {
        this.ebus = ebus;
        this.currentPeriod = TimePeriod.MIDNIGHT;
    }

    public void update(float delta){
        realTime = LocalTime.now();
        if(!useRealTime){
            // delta / ticks = horas
            // * 60 = minutos

            gameMinutes += (delta / tick) * 60f;
            if(gameMinutes >= 24f * 60){
                gameMinutes %=  24 * 60;
            }
        }
        updateCurrentPeriod();
        ebus.post(new TickEvent(getClock()));
    }

    public void updateCurrentPeriod(){
        int hour = getHour();
        currentPeriod = TimePeriod.fromHour(hour);
    }

    public TimePeriod getCurrentPeriod() {
        return currentPeriod;
    }

    public Color getSkyColor(){
        return getCurrentPeriod().getColor();
    }

    public int getHour(){
        return useRealTime ? realTime.getHour() : (int)gameMinutes / 60;
    }

    public int getMinute(){
        return useRealTime ? realTime.getMinute() : (int)gameMinutes % 60;
    }

    public String getClock(){
        return String.format("%02d:%02d", getHour(), getMinute());
    }
}
