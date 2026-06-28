package com.fabricio.fishing.features.mining;

import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.entity.StaticEntity;
import com.fabricio.fishing.entity.components.HealthComponent;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.entity.statics.ClickableObjectEntity;
import com.fabricio.fishing.event.input.Clickable;
import com.fabricio.fishing.features.mining.enums.Ores;

public class Ore extends StaticEntity implements Clickable {
    Polygon poly;
    Ores ore;
    HealthComponent health;

    public Ore(float x, float y, float z, Ores ore) {
        super(x, y, z, ore.texture());
        this.ore = ore;
        addCategories(EntityIndex.ENTITY, EntityIndex.CLICKABLE);
        initPolygon();
        health = new HealthComponent(2);
    }

    @Override
    public void onClick() {
        health.damage(1);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(health.isDead()) C.entities().markForRemoval(this);
    }

    @Override
    public Polygon getBounds() {
        return poly;
    }
    public void initPolygon(){
        poly = ClickableObjectEntity.createPolygon(width, height);
        poly.setPosition(pos.x,pos.y);
    }
}
