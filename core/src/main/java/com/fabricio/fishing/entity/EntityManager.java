package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.utils.Array;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.features.fishing.records.FishCaughtEvent;
import com.fabricio.fishing.features.fishing.Fish;
import com.fabricio.fishing.entity.interfaces.Clickable;
import com.fabricio.fishing.entity.interfaces.HasBounds;
import com.fabricio.fishing.features.fishing.records.FishingZoneSwitchEvent;
import com.fabricio.fishing.features.player.Player;
import com.fabricio.fishing.screen.RenderLayer;

import java.util.EnumMap;

import static com.fabricio.fishing.features.GameContext.*;

public class EntityManager {
    private final EnumMap<EntityIndex, Array<Entity>> indexes = new EnumMap<>(EntityIndex.class);

    private final Array<Entity> pendingRemoval = new Array<>();

    public EntityManager() {
        for (EntityIndex index : EntityIndex.values()){
            indexes.put(index, new Array<>());
        }
        eventBus.register(FishCaughtEvent.class, event -> {
            markForRemoval(event.fish());
        });
        eventBus.register(FishingZoneSwitchEvent.class, e -> {
            clearIndex(EntityIndex.FISH);
        });
    }

    public void register(Entity entity){
        indexes.get(EntityIndex.ALL).add(entity);
        for(EntityIndex index : entity.getCategories())
            indexes.get(index).add(entity);
    }

    private void remove(Entity entity) {
        for (Array<Entity> list : indexes.values()) {
            list.removeValue(entity, true);
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

    public void render(RenderLayer layer, SpriteBatch batch) {
        for (Entity entity : indexes.get(EntityIndex.ALL)) {
            if (entity.getRenderLayer() == layer) entity.render(batch);
        }
    }

    public void clearScene(){
        for (Entity entity : new Array<>(indexes.get(EntityIndex.ALL))){
            if(entity != player) {
                System.out.println(entity.toString());
                remove(entity);
            };
        }
    }

}
