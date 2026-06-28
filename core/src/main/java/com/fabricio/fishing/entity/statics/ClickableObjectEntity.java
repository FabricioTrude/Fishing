package com.fabricio.fishing.entity.statics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.entity.StaticEntity;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.event.input.Clickable;

public class ClickableObjectEntity extends StaticEntity implements Clickable {
    protected Polygon polygon;

    public ClickableObjectEntity(float x, float y, float z, TextureRegion texture) {
        super(x, y, z, texture);
        addCategories(EntityIndex.CLICKABLE, EntityIndex.DECORATION);
        setSize(sprite.getWidth(), sprite.getHeight());
        System.out.println(y);
        polygon = new Polygon(new float[]{0, 0, width, 0, width, height, 0, height});
        polygon.setPosition(x,y);
        setPos(x,y,z);
    }
    public ClickableObjectEntity(float x, float y, float z, Texture texture){this(x,y,z, new TextureRegion(texture));}

    private Runnable onClick;
    public void setOnClick(Runnable onClick){
        this.onClick = onClick;
    }

    @Override
    public void onClick() {
        if (onClick != null) onClick.run();
    }

    @Override
    public Polygon getBounds() {
        return polygon;
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
}
