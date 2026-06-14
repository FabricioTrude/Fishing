package com.fabricio.fishing.screen.ui.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TextureActor extends Actor {
    private final Texture texture;

    public TextureActor(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color old = batch.getColor();
        batch.setColor(
          getColor().r,
          getColor().g,
          getColor().b,
          getColor().a * parentAlpha
        );
        batch.draw(
            texture,
            getX(),
            getY(),
            getWidth(),
            getHeight()
        );
        batch.setColor(old);
    }
}
