package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.screen.RenderLayer;

public class SpriteEntity extends Entity{
    private final Sprite sprite;

    private static final EntityIndex[] indexes = {EntityIndex.SPRITE};

    public SpriteEntity(Texture texture, RenderLayer layer) {
        super(0,0, layer, indexes);
        this.sprite = new Sprite(texture);
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public void update(float delta) {}
}
