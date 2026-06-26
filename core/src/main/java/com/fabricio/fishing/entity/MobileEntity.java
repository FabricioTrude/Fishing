package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.entity.enums.EntityState;

import static java.lang.Float.NaN;

public abstract class MobileEntity extends SpriteEntity {
    protected EntityState state;
    protected Vector2 tPos = new Vector2(NaN, NaN);
    public float dX(){return tPos.x - pos.x;}
    public float dY(){return tPos.y - pos.y;}
    protected Vector2 dir = new Vector2();
    protected Vector2 velocity = new Vector2();
    protected float speed;

    public MobileEntity(float x, float y, float z, TextureRegion texture, EntityIndex... categories) {
        super(x, y, z, texture);
        addCategories(categories);
    } public MobileEntity(float x, float y, float z, Texture texture){this(x,y,z,new TextureRegion(texture));}

    @Override
    public void update(float delta) {
        super.update(delta);
        if(centered){
            sprite.setPosition(rX(), rY());
        } else{
            sprite.setPosition(pos.x,pos.y);
        }
    }

    public void setTarget(float x,float y){
        tPos.x = x;
        tPos.y = y;
    }
}
