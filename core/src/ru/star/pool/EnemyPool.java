package ru.star.pool;

import com.badlogic.gdx.audio.Sound;

import ru.star.base.SpritesPool;
import ru.star.math.Rect;
import ru.star.sprite.Enemy;

public class EnemyPool extends SpritesPool<Enemy> {

    private BulletPool bulletPool;
    private Sound bulletSound;
    private Rect worldBounds;

    public EnemyPool(BulletPool bulletPool, Sound bulletSound, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.bulletSound = bulletSound;
        this.worldBounds = worldBounds;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, bulletSound, worldBounds);
    }
}
