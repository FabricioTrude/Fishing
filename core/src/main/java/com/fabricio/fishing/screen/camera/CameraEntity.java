package com.fabricio.fishing.screen.camera;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.enums.EntityIndex;

import static com.fabricio.fishing.context.GlobalContext.*;

public class CameraEntity extends Entity {

    Entity following = null;

    public CameraEntity(Entity following) {
        super(0, 0, 0);
        addCategory(EntityIndex.NOT_REMOVE);
        target(following);
    }

    @Override
    public void update(float delta) {
        if(following == null) {
            pos.x = SCREEN_WIDTH / 2;
            pos.y = SCREEN_HEIGHT / 2;
        } else {
            pos.x = following.getX();
            pos.y = following.getY();
        }
    }

    @Override
    public void render(SpriteBatch batch) {}

    public void target(Entity target){
        following = target;
    }
}
