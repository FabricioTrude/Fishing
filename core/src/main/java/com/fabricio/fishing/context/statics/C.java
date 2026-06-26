package com.fabricio.fishing.context.statics;

import com.fabricio.fishing.context.GameContext;
import com.fabricio.fishing.data.PlayerData;
import com.fabricio.fishing.entity.EntityManager;
import com.fabricio.fishing.screen.camera.CameraEntity;
import com.fabricio.fishing.features.zones.Zones;
import com.fabricio.fishing.manager.ScoreManager;
import com.fabricio.fishing.screen.Scene;

public final class C {
    private static GameContext ctx;

    public static void init() {
        ctx = new GameContext();
        ctx.initCE();
    }

    public static GameContext ctx(){return ctx;}
    public static EntityManager entities(){return ctx.entities();}
    public static ScoreManager score(){return ctx.score();}
    public static PlayerData player(){return ctx.player();}
    public static Scene scene(){return ctx.scene();}
    public static Zones zone(){return ctx.zone();}
    public static CameraEntity CE(){return ctx.CE();}
}
