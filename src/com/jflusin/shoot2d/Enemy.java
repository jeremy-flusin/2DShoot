package com.jflusin.shoot2d;
import com.jflusin.engine.entities.TexturedRectangleEntity;
import com.jflusin.engine.scenes.AbstractScene;


public class Enemy extends TexturedRectangleEntity {

	int _pdv = 5;
	AbstractScene _scene;
	
	public Enemy(int x, int y, int width, int height, AbstractScene scene) {
		super(x, y, width, height, scene);
		_scene = scene;
	}

	
	public void hit() {
		_pdv--;
		if(_pdv <= 0){
			_scene.removeEntity(this); // BOOM !!!!!
		}
	}

	@Override
	public void update() {
		
	}
	
}
