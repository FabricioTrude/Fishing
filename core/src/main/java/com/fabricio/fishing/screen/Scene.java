package com.fabricio.fishing.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Scene {
    void update(float delta);
    void render(SpriteBatch batch);
    void dispose();
}
