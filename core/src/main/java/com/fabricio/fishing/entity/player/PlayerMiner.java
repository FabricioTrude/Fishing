package com.fabricio.fishing.entity.player;

import com.badlogic.gdx.math.Vector2;
import com.fabricio.fishing.context.statics.G;

public class PlayerMiner extends PlayerEntity{
    public PlayerMiner(float x, float y, float z, float s) {super(x, y, z, s);}
    Vector2 dir = new Vector2();
    float speed = 120f;

    @Override
    public void update(float delta) {
        move(delta);
    }

    private void move(float delta){
        dir.set(0,0);
        if(G.input().left()) dir.x -= 1;
        if(G.input().right()) dir.x += 1;
        if(G.input().down()) dir.y -= 1;
        if(G.input().up()) dir.y += 1;
        if(!dir.isZero()) dir.nor();

        x += dir.x * speed * delta;
        y += dir.y * speed * delta;
        setPosition(x,y,z);
    }
}
