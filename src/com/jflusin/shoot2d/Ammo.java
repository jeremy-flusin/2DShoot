package com.jflusin.shoot2d;
import com.jflusin.engine.entities.TexturedRectangleEntity;
import com.jflusin.engine.scenes.AbstractScene;


public class Ammo extends TexturedRectangleEntity {

	public boolean isToDestroyed = false;
	
	public Ammo(int x, int y, AbstractScene scene) {
		super(x, y, 80, 80, scene);
	}

	@Override
	public void update() {
		
	}
	
}
