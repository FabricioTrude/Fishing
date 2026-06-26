package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.entity.enums.EntityIndex;

import java.util.EnumSet;
import java.util.List;

public abstract class Entity implements Comparable<Entity>{
    protected Vector3 pos;
    private final EnumSet<EntityIndex> categories;

    public Entity(float x, float y, float z) {
        pos = new Vector3(x,y,z);
        this.categories = EnumSet.noneOf(EntityIndex.class);
        C.entities().register(this);
    }
    public void addCategory(EntityIndex index){categories.add(index);}
    public void addCategories(EntityIndex... indexes){categories.addAll(List.of(indexes));}
    public EnumSet<EntityIndex> getCategories() {
        return categories;
    }

    public boolean hasCategory(EntityIndex category){
        return categories.contains(category);
    }

    public abstract void update(float delta);

    public abstract void render(SpriteBatch batch);

    public void dispose(){}

    public float getX(){return pos.x;}
    public float getY(){return pos.y;}
    public float getZ(){return pos.z;}
    public void setZ(float z) {
        pos.z = z;
    }
    public void setPos(float x, float y, float z){
        pos.x = x;
        pos.y = y;
        pos.z = z;
    }
    @Override
    public int compareTo(Entity other) {
        return Float.compare(this.pos.z, other.pos.z);
    }
}
