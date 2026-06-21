package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.screen.RenderLayer;

import java.util.Collections;
import java.util.EnumSet;

public abstract class Entity implements Comparable<Entity>{
    protected float x;
    protected float y;
    protected float z = 0;
    protected float width;
    protected float height;

    private RenderLayer render = RenderLayer.WORLD;
    private final EnumSet<EntityIndex> categories;

    public Entity(float x, float y, float z,EntityIndex... categories) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.categories = EnumSet.noneOf(EntityIndex.class);
        Collections.addAll(this.categories, categories);
        C.entities().register(this);
    }

    public EnumSet<EntityIndex> getCategories() {
        return categories;
    }

    public boolean hasCategory(EntityIndex category){
        return categories.contains(category);
    }

    public abstract void update(float delta);

    public abstract void render(SpriteBatch batch);

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public RenderLayer getRender() {
        return render;
    }

    @Override
    public int compareTo(Entity other) {
        return Float.compare(this.z, other.z);
    }
}
