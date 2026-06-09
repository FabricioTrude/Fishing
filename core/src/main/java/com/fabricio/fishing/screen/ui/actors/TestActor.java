package com.fabricio.fishing.screen.ui.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TestActor extends Actor {
    private final Texture texture;

    public TestActor() {
        this.texture = new Texture("fishes/clown_fish.png");
        setBounds(100,100,64,64);
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
