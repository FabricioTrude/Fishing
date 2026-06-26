package com.fabricio.fishing.context.statics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.fabricio.fishing.assets.GameAssets;
import com.fabricio.fishing.assets.AudioManager;
import com.fabricio.fishing.context.GlobalContext;
import com.fabricio.fishing.event.input.InputManager;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.manager.TimeManager;
import com.fabricio.fishing.save.InventoryManager;
import com.fabricio.fishing.save.SaveManager;

import static com.fabricio.fishing.context.GlobalContext.SCREEN_HEIGHT;
import static com.fabricio.fishing.context.GlobalContext.SCREEN_WIDTH;

public final class G {
    private static GlobalContext ctx;

    public static void init(){
        ctx = new GlobalContext();
        G.CO().viewportWidth = SCREEN_WIDTH;
        G.CO().viewportHeight = SCREEN_HEIGHT;
        G.CO().position.set(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, 0);
        G.CO().update();
    }

    public static GlobalContext get(){return ctx;}
    public static EventBus ebus(){return ctx.ebus();}
    public static SaveManager save(){return ctx.save();}
    public static TimeManager time(){return ctx.time();}
    public static InputManager input(){return ctx.input();}
    public static InventoryManager inventory(){return ctx.inventory();}
    public static GameAssets assets(){return ctx.assets();}
    public static AudioManager sound(){return ctx.audio();}
    public static OrthographicCamera CO(){return ctx.CO();}
}
