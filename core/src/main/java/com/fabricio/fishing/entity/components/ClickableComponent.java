package com.fabricio.fishing.entity.components;

import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.SpriteEntity;
import com.fabricio.fishing.event.input.HasBounds;

public class ClickableComponent extends Component implements HasBounds {
    final Entity e;
    private final Polygon bounds;
    private Runnable onClick;

    public ClickableComponent(Entity e, Polygon bounds, Runnable onClick) {
        this.e = e;
        this.bounds = bounds;
        this.onClick = onClick;
    }

    public void click() {
        if(onClick != null) onClick.run();
    }

    public void setOnClick(Runnable onClick) {
        this.onClick = onClick;
    }

    @Override
    public Polygon getBounds() {
        return bounds;
    }

    @Override
    public void update(float delta) {
        bounds.setPosition(entity.getX(), entity.getY());
        if(entity instanceof SpriteEntity sprite) bounds.setRotation(sprite.getRotation());
    }

    public static Polygon createCenteredPolygon(float width, float height){
        return new Polygon(new float[]{
            -width/2f, -height/2f,
            width/2f, -height/2f,
            width/2f, height/2f,
            -width/2f, height/2f
        });
    }
    public static Polygon createPolygon(float width, float height){
        return new Polygon(new float[]{
            0,0,
            width,0,
            width,height,
            0,height
        });
    }

    public void setScale(float s){
        bounds.setScale(s,s);
    }
    public void setScale(float s, float t){
        bounds.setScale(s,t);
    }

}
