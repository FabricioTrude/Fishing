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

    @Override
    public void onClick() {
        System.out.println("CAVERNA CLICADA");
    }

    private void initPolygon(){
        this.polygon = new Polygon(
            new float[]{
                -width/2f, -height/2f,
                width/2f, -height/2f,
                width/2f, height/2f,
                -width/2f, height/2f
            }
        );
    }

    @Override
    public Polygon getBounds() {
        return polygon;
    }
}
