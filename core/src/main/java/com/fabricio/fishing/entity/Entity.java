package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ObjectMap;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.entity.components.Component;

import java.util.EnumSet;
import java.util.List;

public abstract class Entity implements Comparable<Entity>{
    protected Vector3 pos;
    private final ObjectMap<Class<? extends Component>, Component> components = new ObjectMap<>();
    private final EnumSet<EntityIndex> categories;

    public Entity(float x, float y, float z) {
        pos = new Vector3(x,y,z);
        this.categories = EnumSet.noneOf(EntityIndex.class);
        C.entities().register(this);
    }
    public void addCategories(EntityIndex... indexes){
        for(EntityIndex index: indexes){
            categories.addAll(List.of(indexes));
            C.entities().addToIndex(this, index);
        }
    }
    public EnumSet<EntityIndex> getCategories() {
        return categories;
    }

    public boolean hasCategory(EntityIndex category){
        return categories.contains(category);
    }

    public void update(float delta){updateComponents(delta);}
    public void render(SpriteBatch batch){renderComponents(batch);}
    public void dispose(){disposeComponents();}

    public float getX(){return pos.x;}
    public float getY(){return pos.y;}
    public float getZ(){return pos.z;}
    public void setPos(float x, float y, float z){
        pos.x = x;
        pos.y = y;
        pos.z = z;
    }
    @Override
    public int compareTo(Entity other) {
        return Float.compare(this.pos.z, other.pos.z);
    }

    public void addComponent(Component... c){
        for(Component component: c){
            component.setEntity(this);
            components.put(component.getClass(), component);
            component.onAdd();
        }
    }

    public <T extends Component> T getComponent(Class<T> clazz){
        return clazz.cast(components.get(clazz));
    }
    public boolean hasComponent(Class<? extends Component> clazz) {
        return components.containsKey(clazz);
    }

    public void updateComponents(float delta) {
        for (Component component : components.values()) component.update(delta);
    }

    public void renderComponents(SpriteBatch batch) {
        for (Component component : components.values()) component.render(batch);
    }

    public void disposeComponents() {
        for (Component component : components.values()) component.dispose();
    }
}
