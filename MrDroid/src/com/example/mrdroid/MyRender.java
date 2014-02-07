package com.example.mrdroid;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;

public class MyRender implements Renderer {


	private Context context;
	private GLSurfaceView gView;
	
	Tyouten tyouten;

	float[] floatPoints ;
	
	public void inisiarize(Context context, GLSurfaceView glview) {
		this.context = context;
		this.gView = glview;
		
	}	
	
	@Override
	public void onDrawFrame(GL10 gl) {
	
		
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		FloatBuffer vertices;
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(3 * 2 * 4);
		byteBuffer.order(ByteOrder.nativeOrder());
		vertices = byteBuffer.asFloatBuffer();
		
		vertices.put(floatPoints);
		vertices.flip();
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertices);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);


		updateTriangle();
		

	}
	
	private void updateTriangle(){
		tyouten.updateDots(1.0f);
		floatPoints =  tyouten.getPoints();
	}
	

	

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {

		float xCenter = (float)width/2;
		float yCenter = (float)height/2;

		Dot x1 = new Dot(xCenter/2, xCenter, 0, false);
		Dot y1 = new Dot(yCenter/2, yCenter, 0, false);
		
		Dot x2 = new Dot(xCenter + xCenter/2, (float)width, xCenter, true);
		Dot y2 = new Dot(yCenter/2, yCenter, 0, false);		
	
		Dot x3 = new Dot(xCenter, xCenter, xCenter, true);
		Dot y3 = new Dot(yCenter + yCenter/2, (float)height, yCenter, true);			
		
		tyouten = new Tyouten(x1,y1,x2,y2,x3,y3);

		floatPoints =  tyouten.getPoints();
		
		gl.glViewport(0, 0, width, height);
		gl.glOrthof(0, width, 0, height, 1, -1);
	}

	@Override
	public void onSurfaceCreated(GL10 arg0, EGLConfig arg1) {
		// TODO 自動生成されたメソッド・スタブ

	}


	
	

}
