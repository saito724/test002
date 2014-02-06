package com.example.mrdroid;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;




public class GameMain extends Activity {
	public static final float SPEED_RATE_LV1 = 1.0f;
	public static final float SPEED_RATE_LV2 = 1.5f;
	public static final float SPEED_RATE_LV3 = 2.0f;	
	ArrayList<Droidkun> droidkuntati;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		MyGLSV myGlsv = new MyGLSV(this);
		MyRender renderer = new MyRender();
		
		//Render にはドロイド君たちを描画してもらう
		renderer.inisiarize(createDroidkunTati());
		myGlsv.setRenderer(renderer);
		setContentView(myGlsv);
	}

	protected ArrayList<Droidkun> createDroidkunTati() {
		droidkuntati = new ArrayList<Droidkun>();
		//設定から読み込むようにしたい。
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		Droidkun firstDroid = new Droidkun(bitmap,10, 10, 100, 1);
		droidkuntati.add(firstDroid);
		return droidkuntati;
	}
	
	@Override
	protected void onDestroy() {
		// TODO 自動生成されたメソッド・スタブ
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO 自動生成されたメソッド・スタブ
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO 自動生成されたメソッド・スタブ
		super.onStop();
	}


}
