package com.fabricio.fishing.assets.statics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public abstract class UIAssets {
    public static Texture TopHud = new Texture("ui/huds/top_hud.png");
    public static Texture BottomHud = new Texture("ui/huds/bottom_hud.png");

    public static Texture wood = new Texture("ui/wood.jpg");

    public static Texture MediumPanel = new Texture("ui/huds/medium_panel.png");

    public static Texture SmallIconButton = new Texture("ui/buttons/small_button.png");
    public static Texture ToggleHudButton = new Texture("ui/buttons/toggle_hud_button.png");

    public static final BitmapFont FONT = new BitmapFont();
    public static final Label.LabelStyle NORMAL = new Label.LabelStyle(FONT, Color.WHITE);

    public static final Texture WHITE;

    static {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();

        WHITE = new Texture(pixmap);

        pixmap.dispose();
    }
}
