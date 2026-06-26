package com.fabricio.fishing.event.input;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.entity.enums.MouseState;
import com.fabricio.fishing.event.records.GroundClickEvent;

import static com.fabricio.fishing.screen.GameScreen.viewport;

public class ClickManager extends InputAdapter {
    private Clickable clickedObject;
    private Holdable heldObject;
    private MouseState state = MouseState.IDLE;

    private long clickStartTime;
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        state = MouseState.PRESSED;
        Vector3 mousePos = new Vector3();
        mousePos.set(screenX,screenY, 0);
        viewport.unproject(mousePos);

        for (Entity entity : C.entities().get(EntityIndex.CLICKABLE)) {
            Clickable clickable = (Clickable) entity;
            if (!clickable.getBounds().contains(mousePos.x, mousePos.y)) continue;
            clickStartTime = TimeUtils.millis();
            clickedObject = clickable;
            if (clickable instanceof Holdable holdable) {
                heldObject = holdable;
            }
            return true;
        }
        G.ebus().post(new GroundClickEvent(mousePos.x, mousePos.y));
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Vector3 mousePos = new Vector3();
        mousePos.set(screenX,screenY, 0);
        viewport.unproject(mousePos);

        switch (state){
            case PRESSED -> processRelease(mousePos.x, mousePos.y);
            case HOLDING -> processHoldEnd(mousePos.x, mousePos.y);
        }
        state = MouseState.IDLE;
        return false;
    }

    private void processRelease(float x, float y){
        if(clickedObject != null){
            if(clickedObject.getBounds().contains(x, y))
                clickedObject.onClick();
            clickedObject = null;
        }
    }
    private void processHoldEnd(float x, float y){
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
}
