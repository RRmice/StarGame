package ru.star.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.star.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private SpriteBatch batch;
    private Texture background;
    private Texture spaceShip;

    private Vector2 pos;
    private Vector2 direction;

    private Vector2 touch;

    private boolean move;

    private boolean topPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;


    @Override
    public void show() {
        super.show();

        batch = new SpriteBatch();
        background = new Texture("background.jpg");
        spaceShip = new Texture("spShip.jpg");

        //Инициализируем корабль в центр экрана
        pos = new Vector2((Gdx.graphics.getWidth()- (spaceShip.getWidth() / 2)) / 2 ,
                (Gdx.graphics.getHeight() - (spaceShip.getHeight() / 2)) / 2);

        direction = new Vector2(pos);

        move = false;

        boolean topPressed = false;
        boolean downPressed = false;
        boolean leftPressed = false;
        boolean rightPressed = false;

    }



    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.9f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(spaceShip, pos.x, pos.y);
        batch.end();

        //Движение по кнопкам
        pos.add(buttonDirection());

        //Движение по клику
        if (move) {

            if (pos.dst(touch) < 1) {
                move = false;

                pos.x = touch.x;
                pos.y = touch.y;

            } else {
                pos.add(direction);
            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        spaceShip.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);

        //Храним координаты нажатия
        touch = new Vector2(screenX, Gdx.graphics.getHeight() - screenY);

        //Задаем нормализвованный вектор
        direction = new Vector2(new Vector2(screenX, Gdx.graphics.getHeight() - screenY).sub(pos)).nor();

        //Разрешаем движение по клику
        move = true;

        return false;
    }


    @Override
    public boolean keyDown(int keycode) {

        super.keyDown(keycode);

        keyMap(keycode, true);

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        super.keyUp(keycode);

        keyMap(keycode, false);

        return false;
    }

    //Метод хранит карту управляет нажатием кнопок управления
    private void keyMap(int keycode, boolean pressed){

        switch (keycode) {
            case 19:
                topPressed = pressed;
                break;
            case 20:
                downPressed = pressed;
                //move = false;
                break;
            case 21:
                leftPressed = pressed;
                //move = false;
                break;
            case 22:
                rightPressed = pressed;
                //move = false;
                break;
        }
    }

    private Vector2 buttonDirection(){

        Vector2 keyVector = new Vector2(0,0);

        if (topPressed) {
            keyVector.add(0,1);
            move = false;
        }

        if (downPressed){
            keyVector.add(0 , -1);
            move = false;
        }

        if (leftPressed){
            keyVector.add(-1,0);
            move = false;
        }

        if (rightPressed){
            keyVector.add(1, 0);
            move = false;
        }

        return keyVector.nor();
    }

}
