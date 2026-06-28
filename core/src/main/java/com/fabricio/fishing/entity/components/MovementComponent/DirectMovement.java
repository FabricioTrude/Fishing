package com.fabricio.fishing.entity.components.MovementComponent;

public class DirectMovement implements MovementType{
    @Override
    public void update(MovementComponent move, float delta) {
        float dX = move.dX();
        float dY = move.dY();
        float dist = move.dist(dX,dY);
        if(move.reachedTarget(0.001f)) return;
        move.dir.set(dX/dist, dY/dist);
        move.setPos(
            move.getEX() + (move.dir.x * move.getSpeed() * delta * move.getSpeedModifier()),
            move.getEY() + (move.dir.y * move.getSpeed() * delta * move.getSpeedModifier())
            );
    }
}
