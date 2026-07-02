package com.fabricio.fishing.screen.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraOrthographic extends OrthographicCamera {
    public CameraOrthographic() {
        super();
    }

    public void setZoom(float zoom){
        this.zoom = zoom;
        update();
    }
}
