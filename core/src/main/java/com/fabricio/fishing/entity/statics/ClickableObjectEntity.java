package com.fabricio.fishing.entity.statics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.entity.StaticEntity;
import com.fabricio.fishing.entity.components.ClickableComponent;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.event.input.Clickable;

public class ClickableObjectEntity extends StaticEntity{
    protected ClickableComponent clickable;
    public ClickableObjectEntity(float x, float y, float z, TextureRegion texture) {
        super(x, y, z, texture);
        addCategories(EntityIndex.CLICKABLE, EntityIndex.DECORATION);
        setSize(sprite.getWidth(), sprite.getHeight());
        setPos(x,y,z);
        clickable = new ClickableComponent(this, ClickableComponent.createPolygon(width, height),
            () -> onClick.run());
        addComponent(clickable);
    }
    public ClickableObjectEntity(float x, float y, float z, Texture texture){this(x,y,z, new TextureRegion(texture));}
    private Runnable onClick;
    public void setOnClick(Runnable onClick){
        this.onClick = onClick;
        clickable.setOnClick(onClick);
    }
}
