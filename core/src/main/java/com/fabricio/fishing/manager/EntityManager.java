package com.fabricio.fishing.manager;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.utils.Array;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.features.fishing.Fish;
import com.fabricio.fishing.entity.interfaces.Clickable;
import com.fabricio.fishing.entity.interfaces.HasBounds;
import com.fabricio.fishing.entity.player.Player;
import com.fabricio.fishing.event.Event;
import com.fabricio.fishing.event.FishDiedEvent;

public class EntityManager {
    private final Array<Entity> entities = new Array<>();
    private final Array<Fish> fishes = new Array<>();
    private final Array<Clickable> clickables = new Array<>();
    private final Array<Entity> pendingRemoval = new Array<>();

    public void addEntity(Entity entity){
        this.clickables.add((Clickable)entity);
        switch(entity){
            case Player player -> {}
            case Fish fish -> fishes.add(fish);
            default -> {}
        }
        entities.add(entity);
    }

    public Array<Entity> getEntities(){
        return entities;
    }

    public void removeEntity(Entity entity){
        if(entity instanceof  Fish fish)
            fishes.removeValue(fish, true);
        if(entity instanceof  Clickable clickable)
            this.clickables.removeValue(clickable, true);

        entities.removeValue(entity, true);
    }

    public Array<Fish> getFishes(){
        return fishes;
    }

    public Array<Clickable> getClickables() { return clickables; }

    public void markForRemoval(Entity entity){
        pendingRemoval.add(entity);
    }

    public void flushRemovals(){
        for(Entity entity : pendingRemoval){
            removeEntity(entity);
        }

        pendingRemoval.clear();
    }

    public void renderBoxes(ShapeRenderer shapeRenderer){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        for(Entity entity : getEntities()){
            if(!(entity instanceof HasBounds hasBounds))
                continue;
            Polygon rect = hasBounds.getBounds();
            shapeRenderer.polygon(rect.getTransformedVertices());
        }
        shapeRenderer.end();
    }

    public void handle(Event event){
        if(event instanceof FishDiedEvent e){
            markForRemoval(e.fish);
        }
    }
}
