package com.fabricio.fishing.features.player;

import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.event.annotations.Subscribe;
import com.fabricio.fishing.event.records.GroundClickEvent;
import com.fabricio.fishing.entity.components.MovementComponent.*;

public class PlayerMiner extends PlayerEntity{
    public PlayerMiner(float x, float y, float z, float s) {
        super(x, y, z, s);
        G.ebus().register(this);
        movement.setSpeed(120f);
    }
    @Override
    public void dispose(){
        super.dispose();
        G.ebus().unregister(this);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        move();
    }

    private void move(){
        movement.dir.set(0,0);
        if(G.input().left()) movement.dir.x -= 1;
        if(G.input().right()) movement.dir.x += 1;
        if(G.input().down()) movement.dir.y -= 1;
        if(G.input().up()) movement.dir.y += 1;
        if(!movement.dir.isZero()){
            movement.dir.nor();
            movement.setType(new ControlledMovement());
        }
    }

    @Subscribe
    public void onGroundClick(GroundClickEvent e){
        setTarget(e.x(), e.y());
        movement.setType(new DirectMovement());
    }
}
