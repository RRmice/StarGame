package ru.star.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.star.base.ScaledTouchUpButton;
import ru.star.math.Rect;
import ru.star.screen.GameScreen;

public class ButtonPlay extends ScaledTouchUpButton {

    private Game game;

    public ButtonPlay(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btPlay"));
        this.game = game;
        setHeightProportion(0.2f);
    }

    @Override
    public void resize(Rect wordBounds) {
        setRight(wordBounds.getRight() - 0.03f);
        setBottom(wordBounds.getBottom() + 0.03f);
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen());
    }
}
