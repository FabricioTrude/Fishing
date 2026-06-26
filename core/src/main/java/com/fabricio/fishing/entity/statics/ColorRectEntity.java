package com.fabricio.fishing.entity.statics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.entity.Entity;

public class ColorRectEntity extends Entity {
    private Color color;
    float width;
    float height;

    public ColorRectEntity(float x, float y, float width, float height, Color color, float z) {
        super(x, y, z);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setColor(color);
        batch.draw(UIAssets.WHITE, pos.x, pos.y, width, height);
        batch.setColor(Color.WHITE);
    }

    private Runnable update;

    public ColorRectEntity setUpdate(Runnable update){
        this.update = update;
        return this;
    }

    @Override
    public void update(float delta) {
        if(update != null) update.run();
    }

    public void setColor(Color color){
        this.color = color;
    }
}
