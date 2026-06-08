package com.fabricio.fishing.manager;

import com.fabricio.fishing.event.Event;
import com.fabricio.fishing.event.FishDiedEvent;

public class ScoreManager {

    private float score = 0;

    public void handle(Event event){
        if(event instanceof FishDiedEvent e){
            incrementScore(e.fishValue);
            System.out.println("Score: "+score);
        }
    }

    public void incrementScore(float value){
        this.score += value;
    }
    public float getScore(){
        return this.score;
    }
}
