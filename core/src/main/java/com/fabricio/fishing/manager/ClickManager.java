package com.fabricio.fishing.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.interfaces.Clickable;

public class ClickManager {

    private final EntityManager entityManager;
    public ClickManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public void update(){
        if(!Gdx.input.justTouched())
            return;

        float mouseX = Gdx.input.getX();
        float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();


        for(Clickable clickable : entityManager.getClickables()){
            if(clickable.getBounds().contains(mouseX, mouseY)){
                clickable.onClick();
            }
        }
    }
}
