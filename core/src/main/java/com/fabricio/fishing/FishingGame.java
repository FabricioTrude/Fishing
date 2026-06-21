package com.fabricio.fishing;

import com.badlogic.gdx.Game;
import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.screen.GameScreen;

public class FishingGame extends Game {
    @Override
    public void create() {
        G.init();
        setScreen(new GameScreen());
    }
}
