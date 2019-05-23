package ru.star.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.star.base.Sprite;
import ru.star.math.Rect;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect wordBounds) {
        setHeightProportion(1f);
        pos.set(wordBounds.pos);
    }
}
