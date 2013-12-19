package com.jflusin.shoot2d;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import com.jflusin.engine.scenes.AbstractScene;
import com.jflusin.engine.scenes.SceneFactory;


public class TestScene extends AbstractScene{

	public TestScene(SceneFactory pScreenFactory) {
		super(pScreenFactory);
	}


	float _x = -1f;
	float _y = 0f;
	
	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(0f, 0f, 0f, 1f);
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {

	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		//fond

		gl.glBlendFunc(GL2.GL_ONE_MINUS_SRC_ALPHA, GL2.GL_ZERO);
		gl.glDisable(GL2.GL_DEPTH_TEST);
		gl.glEnable(GL2.GL_BLEND);
		
		int precision = 250;
		for(int i = 0; i < precision; i++){
			float alpha = (float)1/precision * (float)i;
			gl.glColor4f(1,1,1, alpha);
			drawCircle(0.3f/precision * i, gl);
		}
		gl.glDisable(GL2.GL_BLEND);
		
		//player
		gl.glColor4f(1f, 0f, 0f, 1f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2f(_x+0f, _y+0.05f);
		gl.glVertex2f(_x+0.05f, _y+0.05f);
		gl.glVertex2f(_x+0.05f, _y+0f);
		gl.glVertex2f(_x+0f, _y+0f);
		gl.glEnd();
		
		_x += 0.005f;
		
//		if(_x >= 1f) _x = -1f;
	}
	
	void drawCircle(float radius, GL2 gl)
	{
	   gl.glBegin(GL2.GL_LINE_LOOP);
	 
	   for (int i=0; i < 360; i++)
	   {
	      float degInRad = (float)i * (float)(Math.PI/180);
	      gl.glVertex2f((float)Math.cos(degInRad)*radius,(float)Math.sin(degInRad)*radius);
	   }
	 
	   gl.glEnd();
	}
	

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		
	}

}
