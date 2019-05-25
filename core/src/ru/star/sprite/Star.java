package ru.star.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.star.base.Sprite;
import ru.star.math.Rect;
import ru.star.math.Rnd;

public class Star extends Sprite {

    private Vector2 v;
    private Rect worldBounds;
    private float height;

    public Star(TextureAtlas atlas) {
        super(atlas.findRegion("star"));
        float vX = Rnd.nextFloat(-0.005f, 0.005f);
        float vY = Rnd.nextFloat(-0.5f, -0.1f);
        v = new Vector2(vX, vY);
        height = Rnd.nextFloat(0.009f, 0.012f);
        setHeightProportion(height);
    }

    @Override
    public void update(float delta) {
        if (height >= 0.015f) {
            height = 0.009f;
        } else {
            height += 0.0001f;
        }
        setHeightProportion(height);
        pos.mulAdd(v, delta);
        if (getRight() < worldBounds.getLeft()) {
            setLeft(worldBounds.getRight());
        }
        if (getLeft() > worldBounds.getRight()) {
            setRight(worldBounds.getLeft());
        }
        if (getTop() < worldBounds.getBottom()) {
            setBottom(worldBounds.getTop());
        }
    }

    @Override
    public void resize(Rect wordBounds) {
        this.worldBounds = wordBounds;
        float posX = Rnd.nextFloat(wordBounds.getLeft(), wordBounds.getRight());
        float posY = Rnd.nextFloat(wordBounds.getBottom(), wordBounds.getTop());
        pos.set(posX, posY);
    }
}
