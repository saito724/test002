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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_main, menu);
		return true;
	}

}
