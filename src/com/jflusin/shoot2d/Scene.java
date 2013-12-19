package com.jflusin.shoot2d;
import java.util.ArrayList;

import com.jflusin.engine.scenes.AbstractScene;
import com.jflusin.engine.scenes.SceneFactory;

public class Scene extends AbstractScene {

	private Player player;
	private Enemy badGuy;
	private ArrayList<Ammo> ammos;
	public Scene(SceneFactory pScreenFactory) {
		super(pScreenFactory);
		player = new Player(20, 300, 80, 67, getSceneFactory().getGame().getKeyboardListener(), this);
		badGuy = new Enemy(700, 300, 80, 42, this);

		mapTexture(Ammo.class, "src/ammo.png");
		mapTexture(Player.class, "src/starship.png");
		mapTexture(Enemy.class, "src/enemy.png");
		
		ammos = new ArrayList<>();
		addEntity(player);
		addEntity(badGuy);
	}

	@Override 
	protected void update() {
		player.update();
		badGuy.update();
		
		for (Ammo ammo: ammos) {
			if(ammo.getBounds().intersects(badGuy.getBounds())){
				removeEntity(ammo);
				badGuy.hit();
			}
		}
	}

	public void addAmmo(Ammo ammo){
		ammos.add(ammo);
		addEntity(ammo);
	}
	
	public void removeAmmo(Ammo ammo){
		ammos.remove(ammo);
	}
	
}
