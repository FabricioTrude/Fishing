package com.fabricio.fishing.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
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

    public void update(){
        if(!Gdx.input.justTouched()) return;

        float mouseX = Gdx.input.getX();
        float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

        for(Clickable clickable : entityManager.getClickables()){
            if(clickable.getBounds().contains(mouseX, mouseY)){
                ClickManager.setTriggedEntity((Entity) clickable);
                switch(triggedEntity){
                    case Holdable holdable -> {
                        if(holdable.isFirstHold()) {
                            clickable.onClick();
                            holdable.setFirstHold(false);
                        }
                        if(holdable.isHolding()){
                            holdable.onHold();
                            holdable.setHolding(true);
                        }else if (!holdable.isHolding() && !holdable.isFirstHold()){
                            holdable.onRelease();
                            holdable.setHolding(false);
                            holdable.setFirstHold(true);
                        }
                    }
                    default -> {
                        clickable.onClick();
                    }
                }
            }
        }

        System.out.print('D');

    }
}
