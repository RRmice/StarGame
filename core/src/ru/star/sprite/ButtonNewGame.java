package ru.star.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.star.base.ScaledTouchUpButton;
import ru.star.math.Rect;
import ru.star.screen.GameScreen;

public class ButtonNewGame extends ScaledTouchUpButton {

    private GameScreen gameScreen;

    public ButtonNewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.05f);
        setBottom(-0.1f);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}
