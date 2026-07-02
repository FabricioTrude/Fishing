package com.fabricio.fishing.entity.components.MovementComponent;

import com.badlogic.gdx.math.MathUtils;

public class CameraMovement implements MovementBehavior {
    float smoothness = 8f;
    @Override
    public void update(MovementComponent move, float delta) {
        float alpha = 1f - (float)Math.exp(-smoothness * delta);

        move.setPos(
            MathUtils.lerp(move.getEX(), move.tX(), alpha),
            MathUtils.lerp(move.getEY(), move.tY(), alpha)
        );
    }
}
