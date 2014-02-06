package com.example.mrdroid;

import javax.microedition.khronos.opengles.GL10;

import android.graphics.Bitmap;

public class Droidkun {

	private int width;
	private int height;

	private int xPosition;
	private int yPosition;
	private int speed;
	
	private Bitmap bitmap;
	

	
	public Droidkun(Bitmap bitmap,int width, int height, int xPosition, int speed) {
		super();
		this.width = width;
		this.height = height;
		this.xPosition = xPosition;
		this.speed = speed;

		this.yPosition = 0;
		this.bitmap = bitmap;
	}

	public void draw(GL10 gl) {
		

	}

	/**
	 * 
	 */
	public void fail() {
		this.yPosition += speed;
	}



}
