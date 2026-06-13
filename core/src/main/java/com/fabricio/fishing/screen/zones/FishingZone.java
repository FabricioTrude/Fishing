package com.fabricio.fishing.screen.zones;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface FishingZone {
    void update(float delta);
    void render(SpriteBatch batch);
    void dispose();
}
