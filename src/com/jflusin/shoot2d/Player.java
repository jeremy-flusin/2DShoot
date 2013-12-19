package com.jflusin.shoot2d;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import com.jflusin.engine.entities.TexturedRectangleEntity;
import com.jflusin.engine.listeners.KeyboardListener;
import com.jflusin.engine.scenes.AbstractScene;


public class Player extends TexturedRectangleEntity{

	KeyboardListener _keyboardListener;
	AbstractScene _scene;
	int _speed = 20;
	int _pdv = 5;
	ArrayList<Ammo> ammoFired = new ArrayList<>();
	ArrayList<Ammo> ammoDestroyed = new ArrayList<>();
	
	public Player(int x, int y, int width, int height, KeyboardListener keyboardListener, AbstractScene scene) {
		super(x, y, width, height, scene);
		_keyboardListener = keyboardListener;
		_scene = scene;
	}

	@Override
	public void update() {
		
		//Movements
		int y = getY();
		if(_keyboardListener.isKeyPressed(KeyEvent.VK_UP)){
			y += _speed;
		}
		else if(_keyboardListener.isKeyPressed(KeyEvent.VK_DOWN)){
			y -= _speed;
		}
		if (y > 520) y = 520; // borne sup
		if (y < 0) y = 0; //borne inf
		setY(y);
		
		//Fire
		if(_keyboardListener.isKeyPressed(KeyEvent.VK_SPACE)){
		}
		
		//Ammo managing
		for(Iterator<Ammo> it=ammoFired.iterator(); it.hasNext();) {
			Ammo ammo = it.next();
			int x = ammo.getX();
			x += 10;
			if (x > 800) {
				it.remove();
			}
			ammo.setX(x);
		}
		
	}

	public void hit() {
		_pdv--;
		if(_pdv <= 0){
			_scene.removeEntity(this); // BOOM !!!!!
		}
	}
}
