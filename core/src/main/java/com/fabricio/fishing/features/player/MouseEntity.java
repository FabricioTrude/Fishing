package com.fabricio.fishing.features.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.components.MovementComponent.MovementComponent;
import com.fabricio.fishing.entity.enums.EntityIndex;

public class MouseEntity extends Entity {
    MovementComponent movement;
    Vector3 mouse = new Vector3();
    public MouseEntity(float x, float y, float z) {
        super(x, y, z);
        addCategories(EntityIndex.NOT_REMOVE);
        movement = new MovementComponent(this);
        addComponent(movement);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.set(Gdx.input.getX(), Gdx.input.getY(), pos.z);
        mouse.set(pos);
        G.CO().unproject(pos);
        setPos(pos.x, pos.y);
    }

    public float getMouseX(){return mouse.x;}
    public float getMouseY(){return mouse.y;}
}
