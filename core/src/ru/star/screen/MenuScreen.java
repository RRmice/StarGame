package ru.star.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.star.base.BaseScreen;
import ru.star.math.Rect;
import ru.star.sprite.Background;
import ru.star.sprite.PlayerShip;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture playerShipTexture;

    private Background background;
    private PlayerShip playerShip;

    private Vector2 direction;
    private Vector2 speed;
    private Vector2 touchPos;



    @Override
    public void show() {
        super.show();
        bg = new Texture("background.jpg");
        background = new Background(new TextureRegion(bg));

        playerShipTexture = new Texture("spShip.jpg");
        playerShip = new PlayerShip(new TextureRegion(playerShipTexture));

        this.direction = new Vector2(0f,0f);
        this.speed = new Vector2(0.001f, 0.001f);
        this.touchPos = new Vector2(0f, 0f);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.9f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        playerShip.draw(batch);
        batch.end();

        playerShip.pos.add(direction);

       // if(playerShip.isMe(touchPos)){
       //     direction.set(0,0);
       // }

        if (touchPos.dst(playerShip.pos) <= speed.x){
            direction.set(0,0);
            playerShip.pos.set(touchPos);
        }

    }

    @Override
    public void dispose() {
        bg.dispose();
        playerShipTexture.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        playerShip.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {

        super.touchDown(touch, pointer);

        touchPos.set(touch);
        direction.set((new Vector2(touch).sub(playerShip.pos)).nor().scl(speed));
        return false;
    }

}