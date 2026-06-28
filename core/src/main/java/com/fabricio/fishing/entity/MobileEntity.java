package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fabricio.fishing.assets.AnimatedAsset;
import com.fabricio.fishing.entity.components.MovementComponent;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.entity.enums.EntityState;

public abstract class MobileEntity extends SpriteEntity {
    protected EntityState state;
    protected MovementComponent movement;

    public MobileEntity(float x, float y, float z, TextureRegion texture, EntityIndex... categories) {
        super(x, y, z, texture);
        addCategories(categories);
        movement = new MovementComponent(this);
        addComponent(movement);

    }
    public MobileEntity(float x, float y, float z, Texture texture){this(x,y,z,new TextureRegion(texture));}
    public MobileEntity(float x, float y, float z, AnimatedAsset asset){this(x,y,z,asset.defaultFrame());}

    public void setTarget(float x, float y){
        if(movement != null) movement.setTarget(x,y);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(centered){
            sprite.setPosition(rX(), rY());
        } else{
            sprite.setPosition(pos.x,pos.y);
        }
    }
}
