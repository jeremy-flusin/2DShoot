package com.jflusin.shoot2d;
import com.jflusin.engine.entities.TexturedRectangleEntity;
import com.jflusin.engine.scenes.AbstractScene;


public class Background extends TexturedRectangleEntity {

	public Background(AbstractScene _pScene) {
		super(0, 0, 800, 600, _pScene);
	}

	@Override
	public void update() {

	}

}
