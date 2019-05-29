package ru.star.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.star.base.Sprite;
import ru.star.math.Rect;



public class PlayerShip extends Sprite {

    private static final float LEN = 0.005f;

    private Vector2 direction;
    private Vector2 touch;
    private Vector2 buf;


    public static TextureRegion[] getTexture(TextureAtlas atlas){

        TextureRegion reg = atlas.findRegion("main_ship");
        TextureRegion tmp[][] = reg.split(195, 287);

        return tmp[0];

    }

    public PlayerShip(TextureRegion[] regions) {

        super(regions);
        setHeightProportion(0.1f);

        direction = new Vector2();
        touch = new Vector2();
        buf = new Vector2();

    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {

        this.touch = touch;
        direction.set(touch.cpy().sub(pos)).setLength(LEN);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return super.touchUp(touch, pointer);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void update(float delta) {

        buf.set(touch);
        if (buf.sub(pos).len() <= LEN * 2) {
            pos.set(touch);
        } else {
            pos.add(direction);
        }
    }

    @Override
    public void resize(Rect wordBounds) {
        setHeightProportion(0.1f);
    }
}
