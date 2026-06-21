package com.fabricio.fishing.context.statics;

import com.fabricio.fishing.assets.GameAssets;
import com.fabricio.fishing.assets.SoundManager;
import com.fabricio.fishing.context.GlobalContext;
import com.fabricio.fishing.entity.input.InputManager;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.manager.TimeManager;
import com.fabricio.fishing.save.InventoryManager;
import com.fabricio.fishing.save.SaveManager;

public final class G {
    private static GlobalContext ctx;

    public static void init(){
        ctx = new GlobalContext();
    }

    public static GlobalContext get(){return ctx;}
    public static EventBus ebus(){return ctx.ebus();}
    public static SaveManager save(){return ctx.save();}
    public static TimeManager time(){return ctx.time();}
    public static InputManager input(){return ctx.input();}
    public static InventoryManager inventory(){return ctx.inventory();}
    public static GameAssets assets(){return ctx.assets();}
    public static SoundManager sound(){return ctx.sound();}
}
