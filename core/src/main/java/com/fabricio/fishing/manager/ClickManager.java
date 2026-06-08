package com.fabricio.fishing.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.interfaces.Clickable;
import com.fabricio.fishing.entity.interfaces.Holdable;

public class ClickManager {
    private final EntityManager entityManager;
    private static Entity triggedEntity;

    public ClickManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public static Entity getTriggedEntity() {
        return triggedEntity;
    }

    public static void setTriggedEntity(Entity triggedEntity) {
        ClickManager.triggedEntity = triggedEntity;
    }

    private Clickable clickedObject;
    private Holdable heldObject;
    private long clickStartTime;
    private boolean holdStarted;

    public void update(){
        float mouseX = Gdx.input.getX();
        float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

        if(Gdx.input.justTouched()){
            for(Clickable clickable : entityManager.getClickables()){
                if(!clickable.getBounds().contains(mouseX, mouseY)) continue;

                clickedObject = clickable;
                clickStartTime = TimeUtils.millis();
                holdStarted = false;

                if(clickable instanceof Holdable holdable){
                    heldObject = holdable;
                }
                break;
            }
        }

        if (clickedObject != null && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            long holdTime = TimeUtils.millis() - clickStartTime;

            if (heldObject != null){
                if (!holdStarted && holdTime >= 180){
                    holdStarted = true;
                    heldObject.onHoldStart();
                }
                if (holdStarted) heldObject.onHold();
            }

        }
        if(clickedObject != null && !Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            if(heldObject != null){
                if (holdStarted) heldObject.onRelease();
                else clickedObject.onClick();
                heldObject = null;
            } else {
                clickedObject.onClick();
            }
            clickedObject = null;
            holdStarted = false;
        }
    }
}
