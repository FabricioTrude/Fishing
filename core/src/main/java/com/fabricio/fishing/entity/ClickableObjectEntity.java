package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.entity.interfaces.Clickable;
import com.fabricio.fishing.screen.RenderLayer;

public class ClickableObjectEntity extends Entity implements Clickable {
    private final Sprite sprite;
    protected Polygon polygon;

    static EntityIndex[] indexes = {
        EntityIndex.CLICKABLE,
        EntityIndex.DECORATION,
        EntityIndex.SPRITE
    };


    public ClickableObjectEntity(float x, float y, Texture texture, RenderLayer layer) {
        super(x, y, layer, indexes);
        sprite = new Sprite(texture);
        width = sprite.getWidth();
        height = sprite.getHeight();
        sprite.setPosition(x,y);
        initPolygon();
        polygon.setPosition(x,y);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    private Runnable onClick;

    public ClickableObjectEntity setOnClick(Runnable onClick){
        this.onClick = onClick;
        return  this;
    }

    @Override
    public void onClick() {
        if (onClick != null) onClick.run();
    }

    private void initPolygon(){
        this.polygon = new Polygon(
            new float[]{
                0, 0,
                width, 0,
                width, height,
                0, height
            }
        );
    }

    @Override
    public Polygon getBounds() {
        return polygon;
    }
}
