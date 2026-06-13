package com.fabricio.fishing.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.TimeUtils;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.entity.interfaces.Clickable;
import com.fabricio.fishing.entity.interfaces.Holdable;
import com.fabricio.fishing.entity.enums.MouseState;

import static com.fabricio.fishing.features.GameContext.entityManager;

public class ClickManager extends InputAdapter {
    private Clickable clickedObject;
    private Holdable heldObject;
    private MouseState state = MouseState.IDLE;

    private long clickStartTime;
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        state = MouseState.PRESSED;
        int worldY = getWorldY(screenY);
        for (Entity entity : entityManager.get(EntityIndex.CLICKABLE)) {
            Clickable clickable = (Clickable) entity;
            if (!clickable.getBounds().contains(screenX, worldY)) continue;
            clickStartTime = TimeUtils.millis();
            clickedObject = clickable;
            if (clickable instanceof Holdable holdable) {
                heldObject = holdable;
            }
            return true;
        }
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        switch (state){
            case PRESSED -> processRelease(screenX, screenY);
            case HOLDING -> processHoldEnd(screenX, screenY);
        }
        state = MouseState.IDLE;
        return false;
    }

    private void processRelease(int screenX, int screenY){
        if(clickedObject != null){
            if(clickedObject.getBounds().contains(screenX, getWorldY(screenY)))
                clickedObject.onClick();
            clickedObject = null;
        }
    }
    private void processHoldEnd(int screenX, int screenY){
        if(heldObject != null){
            heldObject.onRelease();
            heldObject = null;
        }
    }

    public void update(){
        if(state == MouseState.PRESSED && clickedObject != null){
            long clickTime = TimeUtils.millis() - clickStartTime;

            if (clickTime >= 180) {
                state = MouseState.HOLDING;
                if(clickedObject instanceof Holdable holdable) {
                    holdable.onHoldStart();
                    heldObject = holdable;
                }
                clickedObject = null;
            }
        } else if(state == MouseState.HOLDING && heldObject != null){
            heldObject.onHold();
        }
    }

    private int getWorldY(int screenY){
        return Gdx.graphics.getHeight() - screenY;
    }
}
