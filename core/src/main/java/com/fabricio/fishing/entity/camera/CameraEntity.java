package com.fabricio.fishing.entity.camera;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.enums.EntityIndex;

import static com.fabricio.fishing.context.GlobalContext.*;

public class CameraEntity extends Entity {

    static EntityIndex[] indexes = {EntityIndex.NOT_REMOVE};
    Entity following = null;

    public CameraEntity(Entity following) {
        super(0, 0, 0, indexes);
        target(following);
    }

    @Override
    public void update(float delta) {
        if(following == null) {
            x = SCREEN_WIDTH / 2;
            y = SCREEN_HEIGHT / 2;
        } else {
            x = following.getX();
            y = following.getY();
        }
    }

    @Override
    public void render(SpriteBatch batch) {}

    public void target(Entity target){
        following = target;
    }
}
