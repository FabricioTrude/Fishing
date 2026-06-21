package com.fabricio.fishing.entity.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputManager {
    public ClickManager clickManager;

    public InputManager() {
        clickManager = new ClickManager();
    }

    public boolean left(){
        return Gdx.input.isKeyPressed(Input.Keys.A)
            || Gdx.input.isKeyPressed(Input.Keys.LEFT);
    }
    public boolean right(){
        return Gdx.input.isKeyPressed(Input.Keys.D)
            || Gdx.input.isKeyPressed(Input.Keys.RIGHT);
    }
    public boolean up(){
        return Gdx.input.isKeyPressed(Input.Keys.W)
            || Gdx.input.isKeyPressed(Input.Keys.UP);
    }
    public boolean down(){
        return Gdx.input.isKeyPressed(Input.Keys.S)
            || Gdx.input.isKeyPressed(Input.Keys.DOWN);
    }
}
