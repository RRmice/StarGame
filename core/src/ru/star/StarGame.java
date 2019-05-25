package ru.star;

import com.badlogic.gdx.Game;

import ru.star.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}