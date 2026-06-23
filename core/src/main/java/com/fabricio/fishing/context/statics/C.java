package com.fabricio.fishing.context.statics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.fabricio.fishing.context.GameContext;
import com.fabricio.fishing.data.PlayerData;
import com.fabricio.fishing.entity.EntityManager;
import com.fabricio.fishing.entity.camera.CameraEntity;
import com.fabricio.fishing.features.zones.Zones;
import com.fabricio.fishing.manager.ScoreManager;
import com.fabricio.fishing.screen.Scene;

import static com.fabricio.fishing.context.GlobalContext.SCREEN_HEIGHT;
import static com.fabricio.fishing.context.GlobalContext.SCREEN_WIDTH;

public final class C {
    private static GameContext ctx;

    public static void init() {
        ctx = new GameContext();
        ctx.initCE();
        C.CO().viewportWidth = SCREEN_WIDTH;
        C.CO().viewportHeight = SCREEN_HEIGHT;
        C.CO().position.set(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, 0);
        C.CO().update();
    }

    public static GameContext ctx(){return ctx;}
    public static EntityManager entities(){return ctx.entities();}
    public static ScoreManager score(){return ctx.score();}
    public static PlayerData player(){return ctx.player();}
    public static Scene scene(){return ctx.scene();}
    public static Zones zone(){return ctx.zone();}
    public static OrthographicCamera CO(){return ctx.CO();}
    public static CameraEntity CE(){return ctx.CE();}
}
