package com.fabricio.fishing.ui.generics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class FadingGroup extends Group {
    protected boolean hovered = false;

    @Override
    public void act(float delta) {
        super.act(delta);
        Vector2 mouse = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        getStage().screenToStageCoordinates(mouse);

        Actor hit = getStage().hit(mouse.x, mouse.y, true);

        boolean isHovered =
            hit != null &&
                (hit == this || hit.isDescendantOf(this));

        if (isHovered != hovered) {
            hovered = isHovered;

            clearActions();

            if (hovered) {
                this.addAction(Actions.alpha(1f, 0.2f, Interpolation.fade));
            } else {
                this.addAction(Actions.alpha(0.3f, 0.5f, Interpolation.fade));
            }
        }
    }
}
