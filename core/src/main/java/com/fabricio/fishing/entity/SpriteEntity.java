package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fabricio.fishing.assets.AnimatedAsset;
import com.fabricio.fishing.entity.enums.EntityIndex;

public class SpriteEntity extends Entity {
    protected Sprite sprite;
    protected Animation<TextureRegion> animation;
    protected float stateTime;

    public float rX(){return pos.x-width/2;}
    public float rY(){return pos.y-height/2;}

    protected float width;
    protected float height;
    protected float rotation = 0;
    protected boolean flipped = false;
    protected boolean centered = false;

    public SpriteEntity(float x, float y, float z, TextureRegion texture) {
        super(x,y,z);
        sprite = new Sprite(texture);
        setSize(sprite.getWidth(), sprite.getHeight());
        sprite.setBounds(x,y,width,height);
        addCategories(EntityIndex.SPRITE);
    }
    public SpriteEntity(float x, float y, float z, Texture texture){this(x,y,z,new TextureRegion(texture));}
    public SpriteEntity(float x, float y, float z, AnimatedAsset asset){
        this(x,y,z,asset.defaultFrame());
        animation = asset.defaultAnimation();
    }
    public SpriteEntity(float x, float y, float z, Animation<TextureRegion> animation){
        this(x,y,z,animation.getKeyFrame(0));
        this.animation = animation;
    }


    @Override
    public void update(float delta) {
        super.update(delta);
        if(animation == null) return;
        stateTime += delta;
        sprite.setRegion(animation.getKeyFrame(stateTime, true));
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);
        sprite.draw(batch);
    }

    @Override
    public void setPos(float x, float y, float z) {
        super.setPos(x, y, z);
        sprite.setPosition(pos.x, pos.y);
    }

    public void setCPos(float x, float y, float z){
        super.setPos(x,y,z);
        sprite.setPosition(rX(), rY());
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
        sprite.setSize(width,height);
        sprite.setOriginCenter();
    }
    public void setScale(float s){sprite.setScale(s);}
    public float getScale(){return sprite.getScaleX();}
    public void setRotation(float r){sprite.setRotation(r);}
    public float getRotation(){return sprite.getRotation();}
    public void setAnimation(Animation<TextureRegion> animation){
        this.animation = animation;
        this.stateTime = 0;
        if(animation != null) sprite.setRegion(animation.getKeyFrame(0));
    }
    public Animation<TextureRegion> getAnimation(){
        return animation;
    }
}
