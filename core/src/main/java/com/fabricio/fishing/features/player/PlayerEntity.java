package com.fabricio.fishing.features.player;

import com.badlogic.gdx.math.Polygon;
import com.fabricio.fishing.assets.statics.FeatureAssets;
import com.fabricio.fishing.entity.MobileEntity;
import com.fabricio.fishing.entity.enums.EntityIndex;

public class PlayerEntity extends MobileEntity {
    protected Polygon poly;

    public PlayerEntity(float x, float y, float z) {
        super(x, y, z, FeatureAssets.PlayerTexture);
        addCategories(EntityIndex.PLAYER, EntityIndex.ENTITY);
        poly = new Polygon(new float[]{0,0, width, 0, width, height, 0, height});
        poly.setOrigin(width /2, height /2);;
        setPos(x,y,z);
        centered = true;
    }
    public PlayerEntity(float x, float y, float z, float s) {this(x, y, z);setScale(s);}

    @Override
    public void setScale(float s){
        super.setScale(s);
        if(poly != null) poly.setScale(s,s);
    }

    @Override
    public void setPos(float x, float y, float z) {
        super.setPos(x, y, z);
        if(poly != null) poly.setPosition(rX(),rY());
    }

    public void setScene(float x, float y, float z, float s){
        setPos(x,y,z);
        setScale(s);
    }
}
