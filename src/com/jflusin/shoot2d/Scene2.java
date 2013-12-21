package com.jflusin.shoot2d;
import java.awt.Color;
import java.awt.event.KeyEvent;

import com.jflusin.engine.entities.TexturedRectangleEntity;
import com.jflusin.engine.entities.lights.Light;
import com.jflusin.engine.scenes.AbstractScene;
import com.jflusin.engine.scenes.SceneFactory;


public class Scene2 extends AbstractScene {

	Player _player;
	Enemy _enemy;
	Light _lightPlayer;
	Light _lightEnemy;
	Mask _mask;
	TexturedRectangleEntity _fond;
	Ammo _ammo;
	Light _lightAmmo;
	
	public Scene2(SceneFactory pScreenFactory) {
		super(pScreenFactory);

		//TextureMapping
		mapTexture(Player.class, Player.T_RIGHT, "src/rsrc/starship_right.png");
		mapTexture(Player.class, Player.T_LEFT, "src/rsrc/starship_left.png");
		mapTexture(Enemy.class, 0, "src/rsrc/enemy.png");
		mapTexture(Background.class, 0, "src/rsrc/background.png");
		mapTexture(Ammo.class, 0, "src/rsrc/ammo.png");
		
		//Object instantiation
		_fond = new Background(this);
		_player = new Player(20, 300, 80, 67, getSceneFactory().getGame().getKeyboardListener(), this);
		_enemy = new Enemy(700, 300, 80, 42, this);
		_lightPlayer = new Light(200, 200, 500, 0.1f, new Color(105,205,247), this);
		_lightPlayer.linkToEntity(_player);
		_lightEnemy = new Light(200, 200, 300, 0.03f, Color.red, this);
		_lightEnemy.linkToEntity(_enemy);
		_mask = new Mask(this);
		_ammo = new Ammo(_player.getX(), _player.getY(), this);
		_lightAmmo = new Light(0, 0, 35, 0.02f,  new Color(105,205,247), this);
		_lightAmmo.linkToEntity(_ammo);
		//Adding objects to the openGL scene
		addEntity(_fond);
		addEntity(_mask);
		addEntity(_lightEnemy);
		addEntity(_enemy);
		addEntity(_lightAmmo);
		addEntity(_ammo);
		addEntity(_lightPlayer);
		addEntity(_player);
	}
	
	@Override
	protected void update() {
		if(getSceneFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_O)){
			_lightPlayer.setRadius(0);
			_lightEnemy.setRadius(0);
			_mask.setWidth(0);
			_lightAmmo.setRadius(0);
		}
		if(getSceneFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_P)){
			_lightPlayer.setRadius(150);
			_lightEnemy.setRadius(150);
			_mask.setWidth(800);
			_lightAmmo.setRadius(60);
		}
		if(getSceneFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_X)){
			_lightPlayer.setRadius(_lightPlayer.getRadius() - 5);
		}
		if(getSceneFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_C)){
			_lightPlayer.setRadius(_lightPlayer.getRadius() + 5);
		}
				
		_ammo.setX(_ammo.getX()+10);
		if(_ammo.getX() > 800) {
			_ammo.setX(_player.getX());
			_ammo.setY(_player.getY());
		}
		
		super.update();
	}

}
