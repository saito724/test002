package com.example.mrdroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class GameMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		MyGLSV myGlsv = new MyGLSV(this);
		setContentView(myGlsv);
	}


}
