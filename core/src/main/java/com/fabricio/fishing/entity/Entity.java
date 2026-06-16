package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.screen.RenderLayer;

import java.util.Collections;
import java.util.EnumSet;

import static com.fabricio.fishing.features.GameContext.entityManager;

public abstract class Entity {
    protected float x;
    protected float y;
    protected float width;
    protected float height;

    protected RenderLayer layer;
    private final EnumSet<EntityIndex> categories;

    public Entity(float x, float y, RenderLayer layer,EntityIndex... categories) {
        this.x = x;
        this.y = y;
        this.categories = EnumSet.noneOf(EntityIndex.class);
        Collections.addAll(this.categories, categories);
        this.layer = layer;
        entityManager.register(this);
    }

    public EnumSet<EntityIndex> getCategories() {
        return categories;
    }

    public boolean hasCategory(EntityIndex category){
        return categories.contains(category);
    }

    public RenderLayer getRenderLayer() {
        return layer;
    }

    public abstract void update(float delta);

    public abstract void render(SpriteBatch batch);
}
