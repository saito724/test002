package com.example.mrdroid;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;
import android.util.Log;

public class MyRenderTriangle extends MyRender {

	//Droidkun droid = new Droidkun(10, 10, 50, 100);
	private int SViweWidth =0;
	private int SViweHeight =0 ;
	private GL10 mgl;
	

	float x1 = -1.0f /10;
	float y1 = -1.0f/10;
	float x2 = 1.0f/10;
	float y2 = -1.0f/10;
	float x3 = 0.5f/10;
	float y3 = 1.0f/10;
	float[] hairetu =  new float[] { x1,y1,x2,y2,x3,y3} ;
	
	@Override
	public void onDrawFrame(GL10 gl) {
	
		
		
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

//		int[] vartex = {
//				100 * 0X10000,100 * 0X10000,
//				300 * 0X10000,100 * 0X10000,
//				300 * 0X10000,400 * 0X10000,
//		};
		FloatBuffer vertices;
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(3 * 2 * 4);
		byteBuffer.order(ByteOrder.nativeOrder());
		vertices = byteBuffer.asFloatBuffer();
		
		vertices.put(hairetu);
		vertices.flip();
		

		
//		Log.d("SViweWidth", Integer.toString(SViweWidth));
//		Log.d("SViweHeight", Integer.toString(SViweHeight));
//		
	//	gl.glPointSize(5.0f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertices);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);

		hairetu[0] -=0.001f;
		hairetu[1] -=0.001f;
		hairetu[2]  +=0.001f;
		hairetu[3]  -=0.001f;
		hairetu[4]  +=0.001f;
		hairetu[5]  +=0.001f;
	
		Log.d("SViweHeight", Float.toString(x1));

	}
	
	
	public void setSViweWidth(int sViweWidth) {
		SViweWidth = sViweWidth;
	}

	public void setSViweHeight(int sViweHeight) {
		SViweHeight = sViweHeight;
	}

	@Override
	public void onSurfaceChanged(GL10 arg0, int widtg, int height) {
		this.setSViweWidth(widtg);
		this.setSViweHeight(height);
	}

	@Override
	public void onSurfaceCreated(GL10 arg0, EGLConfig arg1) {
		// TODO 自動生成されたメソッド・スタブ

	}




}
