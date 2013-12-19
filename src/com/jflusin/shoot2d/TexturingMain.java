package com.jflusin.shoot2d;
import com.jflusin.engine.Game;


public class TexturingMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game(800, 600, "Texturing");
		game.getSceneFactory().showScene(new Scene2(game.getSceneFactory()));
	}

}
