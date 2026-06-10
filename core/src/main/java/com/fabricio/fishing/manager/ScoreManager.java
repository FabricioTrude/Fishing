package com.fabricio.fishing.manager;

public class ScoreManager {

    private float score = 0;

    public void incrementScore(float value){
        this.score += value;
    }
    public float getScore(){
        return this.score;
    }
}
