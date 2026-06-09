package com.fabricio.fishing.assets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class UIAssets {
    public static Texture TopHud = new Texture("ui/huds/top_hud.png");
    public static Texture BottomHud = new Texture("ui/huds/bottom_hud.png");

    public static Texture wood = new Texture("ui/wood.jpg");

    public static Texture FishingInventory = new Texture("ui/huds/fishing_inventory.png");

    public static Texture SmallIconButton = new Texture("ui/buttons/small_button.png");

    public static final BitmapFont FONT = new BitmapFont();
    public static final Label.LabelStyle NORMAL = new Label.LabelStyle(FONT, Color.WHITE);
}
