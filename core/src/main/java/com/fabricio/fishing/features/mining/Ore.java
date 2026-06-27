package com.fabricio.fishing.features.mining;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.entity.StaticEntity;
import com.fabricio.fishing.entity.statics.ClickableObjectEntity;
import com.fabricio.fishing.event.input.Clickable;

public class Ore extends StaticEntity implements Clickable {
    Polygon poly;
    public Ore(float x, float y, float z, TextureRegion texture) {
        super(x, y, z, texture);
        poly = ClickableObjectEntity.createPolygon(width, height);
    }

    @Override
    public void onClick() {
        System.out.println("AAA");
    }

    @Override
    public Polygon getBounds() {
        return poly;
    }
}
