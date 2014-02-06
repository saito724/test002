package com.example.mrdroid;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class MyRenderTriangle implements Renderer {

	Droidkun droid = new Droidkun(10, 10, 50, 100);
	
	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		//gl.glTranslatef(0, 0, -3f);

		droid.draw(gl);
	
		

	}

	@Override
	public void onSurfaceChanged(GL10 arg0, int arg1, int arg2) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onSurfaceCreated(GL10 arg0, EGLConfig arg1) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
