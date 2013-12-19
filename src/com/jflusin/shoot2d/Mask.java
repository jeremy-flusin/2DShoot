package com.jflusin.shoot2d;


import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import com.jflusin.engine.entities.RectangleEntity;
import com.jflusin.engine.scenes.AbstractScene;

public class Mask extends RectangleEntity {
	
	public Mask(AbstractScene pScene) {
		super(0, 0, 800, 600, pScene);
	}

	@Override
	public void draw(GLAutoDrawable pDrawable) {
		GL2 gl = pDrawable.getGL().getGL2();
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glDisable(GL2.GL_DEPTH_TEST);
		gl.glEnable(GL2.GL_BLEND);
		gl.glColor4f(0, 0, 0, 0.5f);
		super.draw(pDrawable);
	}

	@Override
	public void update() {

	}
}
