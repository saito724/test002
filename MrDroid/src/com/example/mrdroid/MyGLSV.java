package com.example.mrdroid;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;

public class MyGLSV extends GLSurfaceView {
	MyRender myRender;

	public MyGLSV(Context context) {
		super(context);
		int width = getWidth();
		int height = getHeight();
		
		myRender = new MyRender();
		Log.d("viewwidth", Integer.toString(getWidth()));
		myRender.setSViweWidth(width);
		myRender.setSViweHeight(height);
		setRenderer(myRender);
	}

}
