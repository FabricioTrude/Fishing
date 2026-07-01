package com.fabricio.fishing.entity.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.entity.Entity;

public abstract class Component {
    protected Entity entity;

    public void setEntity(Entity entity){
        this.entity = entity;
    }

    public void onAdd(){}
    public void update(float delta){}
    public void render(SpriteBatch batch){}
    public void dispose(){}
}
