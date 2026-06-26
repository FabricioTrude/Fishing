package com.fabricio.fishing.features.player;

import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.event.annotations.Subscribe;
import com.fabricio.fishing.event.records.GroundClickEvent;

import static java.lang.Float.NaN;

public class PlayerMiner extends PlayerEntity{
    public PlayerMiner(float x, float y, float z, float s) {
        super(x, y, z, s);
        G.ebus().register(this);
        speed = 120f;
    }
    @Override
    public void dispose(){G.ebus().unregister(this);};

    @Override
    public void update(float delta) {
        move(delta);
        super.update(delta);
    }

    private void move(float delta){
        dir.set(0,0);
        if(G.input().left()) dir.x -= 1;
        if(G.input().right()) dir.x += 1;
        if(G.input().down()) dir.y -= 1;
        if(G.input().up()) dir.y += 1;
        if(!dir.isZero()){
            dir.nor();
            tPos.x = NaN;
            tPos.y = NaN;
            pos.x += dir.x * speed * delta;
            pos.y += dir.y * speed * delta;
        }
        if(!Float.isNaN(tPos.x) && !Float.isNaN(tPos.y)){
            float dX = tPos.x - pos.x;
            float dY = tPos.y - pos.y;
            float d = (float)Math.sqrt(dX*dX+dY*dY);
            if(d > speed * delta){
                pos.x += dX / d * speed * delta;
                pos.y += dY / d * speed * delta;
            }
        }
        setPos(pos.x,pos.y,pos.z);
    }

    @Subscribe
    public void onGroundClick(GroundClickEvent e){
        setTarget(e.x(), e.y());
    }
}
