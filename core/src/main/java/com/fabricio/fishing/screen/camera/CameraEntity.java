package com.fabricio.fishing.screen.camera;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.data.PlayerData;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.components.MovementComponent.CameraMovement;
import com.fabricio.fishing.entity.components.MovementComponent.MovementComponent;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.features.player.MouseEntity;

import static com.fabricio.fishing.context.GlobalContext.SCREEN_HEIGHT;
import static com.fabricio.fishing.context.GlobalContext.SCREEN_WIDTH;

public class CameraEntity extends Entity {
    Entity following = null;
    Entity player = PlayerData.getPlayer();
    MouseEntity mouse = C.mouse();

    float lookaroundDistance = 60f;

    float zoom;
    float tZoom;
    protected MovementComponent movement;

    public CameraEntity(Entity following) {
        super(0, 0, 0);
        addCategories(EntityIndex.NOT_REMOVE);
        movement = new MovementComponent(this);
        movement.setSpeed(90);
        movement.setType(new CameraMovement());
        addComponent(movement);
        target(following);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(following == null) {
            movement.setTarget(SCREEN_WIDTH / 2, SCREEN_HEIGHT/2);
        } else {
            movement.setTarget(following.getX(), following.getY());

        }
        if(Math.abs(zoom - tZoom) > 0.001f){
            float alpha = 1f - (float)Math.exp(-6f * delta);
            zoom += (tZoom - zoom) * alpha;
            G.CO().setZoom(zoom);
        }
        lookaround();
    }

    @Override
    public void render(SpriteBatch batch) {}
    public void target(Entity target){
        following = target;
    }
    public void zoomIn(float z){
        tZoom /= z;
    }
    public void zoomOut(float z){
        tZoom *= z;
    }
    public void resetZoom(){
        tZoom = 1;
    }

    public void lookaround(){
        float mx = mouse.getMouseX() / C.scene().getWidth();
        float my = 1f - (mouse.getMouseY() / C.scene().getHeight());
        mx = mx * 2f - 1f;
        my = my * 2f - 1f;
        mx = deadZone(mx, 0.9f);
        my = deadZone(my, 0.8f);
        float offsetX = mx * lookaroundDistance;
        float offsetY = my * lookaroundDistance;
        movement.setTarget(movement.tX() + offsetX, movement.tY() + offsetY);
    }

    private float deadZone(float value, float dead) {

        if (Math.abs(value) < dead)
            return 0;

        return Math.signum(value)
            * (Math.abs(value) - dead)
            / (1f - dead);
    }
}
