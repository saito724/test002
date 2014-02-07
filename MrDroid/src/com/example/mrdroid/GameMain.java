package com.example.mrdroid;

import java.util.EnumMap;
import java.util.LinkedList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;

import com.example.mrdroid.Droidkun.DroidType;

public class GameMain extends Activity implements Renderer, OnTouchListener {
	private MyGLSV myGLSV;
	private int viewWidth;
	private int viewHeight;

	public static final float SPEED_RATE_LV1 = 1.0f;
	public static final float SPEED_RATE_LV2 = 1.5f;
	public static final float SPEED_RATE_LV3 = 2.0f;

	LinkedList<Droidkun> droidkuntati;
	EnumMap<DroidType, Integer> droidEnumMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		myGLSV = new MyGLSV(this);
		myGLSV.setRenderer(this);
		setContentView(myGLSV);
		droidkuntati = new LinkedList<Droidkun>();
	}

	private void startGame() {

		DroidType first_type = Droidkun.DroidType.type1;
		int texture_id = droidEnumMap.get(first_type);

		Droidkun firstDroidkun = new Droidkun(texture_id,
				first_type.getPoint(), first_type.getSpeed(),
				first_type.getSize(), viewWidth / 2);
		droidkuntati.addFirst(firstDroidkun);
	}

//	private Integer getTextureId(int imageId) {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}

	// 更新処理する。（移動・状態判定など）
	private void update() {
		// 1 ドロイドたちを走査して状態判定⇒移動（それぞれのdroidインスタンス）
		for (Droidkun droid : droidkuntati) {
			droid.fail();
		}

		//

	}

//	// 描画する　とりあえずドロイド君のみ
//	private void draw(gl) {
//		for (Droidkun droid : droidkuntati) {
//			droid.draw(gl);
//		}
//
//	}

	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		update();
		for (Droidkun droid : droidkuntati) {
			droid.draw(gl);
		}

	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		this.viewWidth = myGLSV.getWidth();
		this.viewHeight = myGLSV.getHeight();

	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		this.viewWidth = myGLSV.getWidth();
		this.viewHeight = myGLSV.getHeight();

		// glの初期設定
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);

		// ドロイド君の種類（type）ごとにテクスチャを生成してEnumMapにtypeとtexture_idを登録しておく
		droidEnumMap = new EnumMap<Droidkun.DroidType, Integer>(DroidType.class);

		DroidType[] doidTypeValue = DroidType.values();
		for (DroidType type : doidTypeValue) {
			Integer TextureID = TextureLoader.loadTexture(gl, this,
					type.getImageId());// テクスチャ作って、アクセスできるtexture_id を返す
			droidEnumMap.put(type, TextureID);
		}

		startGame();

	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onDestroy();
		myGLSV.onResume();

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
