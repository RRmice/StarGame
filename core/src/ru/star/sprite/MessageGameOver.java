package ru.star.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.star.base.Sprite;

public class MessageGameOver extends Sprite {

    public MessageGameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
        setHeightProportion(0.07f);
        setBottom(0.1f);
    }
}
