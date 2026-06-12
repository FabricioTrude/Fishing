package com.fabricio.fishing.screen.ui.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.fabricio.fishing.assets.statics.UIAssets;

public class ColorActor extends Actor {
    private final Color color = new Color();

    public ColorActor(Color color) {
        this.color.set(color);
    }

    @Override
    public void setColor(Color color) {
        this.color.set(color);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(color);
        batch.draw(UIAssets.WHITE,
            getX(),
            getY(),
            getWidth(),
            getHeight()
        );
        batch.setColor(Color.WHITE);
    }
}
