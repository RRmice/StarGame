package ru.star.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.star.base.Sprite;
import ru.star.math.Rect;
import ru.star.pool.BulletPool;

public abstract class Ship extends Sprite {

    protected BulletPool bulletPool;
    protected TextureRegion bulletRegion;

    protected Vector2 v;
    protected Vector2 v0;
    protected Vector2 bulletV;
    protected float bulletHeight;

    protected Rect worldBounds;

    protected float reloadInterval;
    protected float reloadTimer;

    protected int damage;
    protected int hp;

    protected Sound bulletSound;

    protected boolean battleMode;

    public Ship(TextureRegion region, int rows, int cols, int frames) {
        super(region, rows, cols, frames);
    }

    public Ship() {
        battleMode = false;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);

        if (battleMode) {
            reloadTimer += delta;
            if (reloadTimer >= reloadInterval) {
                reloadTimer = 0f;
                shoot();
            }
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
    }

    private void shoot() {
        bulletSound.play();
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, damage);
    }
}
