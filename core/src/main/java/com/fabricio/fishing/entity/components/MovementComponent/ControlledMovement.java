package com.fabricio.fishing.entity.components.MovementComponent;

public class ControlledMovement implements MovementBehavior {
    @Override
    public void update(MovementComponent move, float delta) {
        move.setPos(
            move.getEX() + (move.dir.x * move.getSpeed() * delta * move.getSpeedModifier()),
            move.getEY() + (move.dir.y * move.getSpeed() * delta * move.getSpeedModifier()));
    }
}
