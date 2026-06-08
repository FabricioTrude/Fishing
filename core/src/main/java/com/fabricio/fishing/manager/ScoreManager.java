package com.fabricio.fishing.manager;

import com.fabricio.fishing.event.Event;
import com.fabricio.fishing.event.FishClickedEvent;

public class ScoreManager {

    private int score = 0;

    public void handle(Event event){
        if(event instanceof FishClickedEvent e){
            incrementScore(e.fishValue);
            System.out.println("Score: "+score);
        }
    }

    public void incrementScore(int value){
        this.score = value;
    }
    public int getScore(){
        return this.score;
    }
}
