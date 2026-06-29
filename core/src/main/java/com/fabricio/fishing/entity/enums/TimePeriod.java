package com.fabricio.fishing.entity.enums;

import com.badlogic.gdx.graphics.Color;

public enum TimePeriod {
    DAWN(3f, 4f, Palette.DAWN_SKY),
    AURORA(4f,5f,Palette.AURORA_SKY),
    SUNRISE(5f, 7f, Palette.SUNRISE_SKY),
    MORNING(7f, 10f, Palette.MORNING_SKY),
    FORENOON(10f, 12f, Palette.FORENOON_SKY),
    NOON(12f, 14f, Palette.NOON_SKY),
    AFTERNOON(14f, 17f, Palette.AFTERNOON_SKY),
    SUNSET(17f,19f, Palette.SUNSET_SKY),
    DUSK(19f, 21f, Palette.DUSK_SKY),
    NIGHT(21f, 23f, Palette.NIGHT_SKY),
    MIDNIGHT(0f, 3f, Palette.MIDNIGHT_SKY);

    private final float startHour;
    private final float endHour;
    private final Color color;

    TimePeriod(float startHour, float endHour, Color color) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.color = color;
    }

    public float getStartHour() {
        return startHour;
    }

    public float getEndHour() {
        return endHour;
    }

    public Color getColor() {
        return color;
    }

    public static TimePeriod fromHour(int hour){
        for(TimePeriod period: values()){
            if(hour >= period.startHour && hour < period.endHour){
                return period;
            }
        }
        return MIDNIGHT;
    }
}
