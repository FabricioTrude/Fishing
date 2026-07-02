package com.fabricio.fishing.context;

import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.data.PlayerData;
import com.fabricio.fishing.entity.EntityManager;
import com.fabricio.fishing.features.player.MouseEntity;
import com.fabricio.fishing.screen.LayeredScene;
import com.fabricio.fishing.screen.camera.CameraEntity;
import com.fabricio.fishing.features.fishing.records.FishingZoneSwitchEvent;
import com.fabricio.fishing.features.zones.Zones;
import com.fabricio.fishing.manager.*;
import com.fabricio.fishing.screen.Scene;
import com.fabricio.fishing.screen.scenes.generic.GenericPond;
import com.fabricio.fishing.screen.scenes.swamp.SwampPond;

public final class GameContext {
    EntityManager entities;
    ScoreManager score;
    PlayerData player;
    Zones zone;
    LayeredScene scene = null;
    CameraEntity CE;
    MouseEntity mouse;

    public GameContext() {
        entities = new EntityManager();
        score = new ScoreManager();
        player = new PlayerData();
        zone = Zones.SWAMP;
        G.ebus().register(FishingZoneSwitchEvent.class, e -> setZone(e.zone()));
    }

    public EntityManager entities(){return entities;}
    public ScoreManager score(){return score;}
    public PlayerData player(){return player;}
    public Zones zone(){return zone;}
    public LayeredScene scene(){return scene;}
    public CameraEntity CE(){return CE;}
    public MouseEntity mouse(){return mouse;}

    public void init(){
        mouse = new MouseEntity(0,0,9999);
        CE = new CameraEntity(null);
    }

    public void setScene(LayeredScene newScene){
        scene = newScene;
    }

    public void setZone(Zones zoneType) {
        if (scene != null) scene.dispose();
        zone = zoneType;
        switch (zoneType) {
            case SWAMP -> scene = new SwampPond(zone);
            default -> scene = new GenericPond(zone);
        }
    }
}
