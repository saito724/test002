package com.example.mrdroid;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSV extends GLSurfaceView {
	MyRender myRender;

	public MyGLSV(Context context) {
		super(context);
		myRender = new MyRender();
		setRenderer(myRender);
	}

}
