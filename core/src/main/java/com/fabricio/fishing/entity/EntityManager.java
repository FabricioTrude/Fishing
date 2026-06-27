package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.utils.Array;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.features.fishing.records.FishCaughtEvent;
import com.fabricio.fishing.event.input.HasBounds;

import java.util.EnumMap;

public class EntityManager {
    private final EnumMap<EntityIndex, Array<Entity>> indexes = new EnumMap<>(EntityIndex.class);

    private final Array<Entity> pendingRemoval = new Array<>();
    private final Array<Entity> renderList = new Array<>();
    private boolean renderDirty = false;

    public EntityManager() {
        for (EntityIndex index : EntityIndex.values()){
            indexes.put(index, new Array<>());
        }
        G.ebus().register(FishCaughtEvent.class, event -> {
            markForRemoval(event.fish());
        });
    }

    public void register(Entity entity){
        renderList.add(entity);
        indexes.get(EntityIndex.ALL).add(entity);
        for(EntityIndex index : entity.getCategories())
            indexes.get(index).add(entity);
        renderDirty = true;
    }

    private void remove(Entity entity) {
        entity.dispose();
        for (Array<Entity> list : indexes.values()) {
            list.removeValue(entity, true);
            renderList.removeValue(entity, true);
        }
    }

    public void clearIndex(EntityIndex index){
        Array<Entity> entitiesToRemove = new Array<>(indexes.get(index));
        for(Entity entity : entitiesToRemove)remove(entity);
    }

    @SuppressWarnings("unchecked")
    public <T extends Entity> Array<T> get(EntityIndex index) {
        return (Array<T>) indexes.get(index);
    }

    public void markForRemoval(Entity entity) {
        pendingRemoval.add(entity);
    }

    public void flushRemovals() {
        for (Entity entity : pendingRemoval) {
            remove(entity);
        }
        pendingRemoval.clear();
    }

    public void renderBoxes(ShapeRenderer shapeRenderer){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        for(Entity entity : indexes.get(EntityIndex.ALL)){
            if(!(entity instanceof HasBounds hasBounds))
                continue;
            Polygon rect = hasBounds.getBounds();
            shapeRenderer.polygon(rect.getTransformedVertices());
        }
        shapeRenderer.end();
    }

    public void update(float delta){
        for (Entity entity : indexes.get(EntityIndex.ALL)) {
            entity.update(delta);
        }
    }

    public void render(SpriteBatch batch) {
       if(renderDirty) {
           renderList.sort();
           renderDirty = false;
       }

       for(Entity entity: renderList){
           entity.render(batch);
       }
    }

    public void clearScene(){
        for (Entity entity : indexes.get(EntityIndex.ALL)){
            if(!entity.hasCategory(EntityIndex.NOT_REMOVE)) {
                markForRemoval(entity);
            }
        }
    }

    public void addToIndex(Entity entity, EntityIndex index){indexes.get(index).add(entity);}
}
