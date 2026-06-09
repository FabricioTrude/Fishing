package com.fabricio.fishing.screen.ui.actors;

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
        batch.draw(
            texture,
            getX(),
            getY(),
            getWidth(),
            getHeight()
        );
    }
}
