package ru.star.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.star.base.Sprite;

public class MassageNewGame extends Sprite {

    public MassageNewGame(TextureAtlas atlas) {
        super(atlas.findRegion("button_new_game"));
        setHeightProportion(0.07f);
    }

}
