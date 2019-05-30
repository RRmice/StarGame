package ru.star.pool;

import ru.star.base.SpritesPool;
import ru.star.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
