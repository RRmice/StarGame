package ru.star.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.star.base.Sprite;
import ru.star.math.Rect;

public class MessageGameOver extends Sprite {

    public MessageGameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.07f);
        setBottom(0.009f);
    }
}
