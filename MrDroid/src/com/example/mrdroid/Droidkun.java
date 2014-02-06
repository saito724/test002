package com.example.mrdroid;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.text.BreakIterator;

import javax.microedition.khronos.opengles.GL10;

import android.R.integer;
import android.graphics.Bitmap;

public class Droidkun {

	private int width;
	private int height;

	private int xPosition;
	private int yPosition;
	private int speed;
	
	private int image;
	

	
	public Droidkun(int width, int height, int xPosition, int speed) {
		super();
		this.width = width;
		this.height = height;
		this.xPosition = xPosition;
		this.speed = speed;

		this.yPosition = 0;
		this.image =  R.drawable.ic_launcher;
	}

	public void draw(GL10 gl) {
		

	}

	/**
	 * 
	 */
	public void fail() {
		this.yPosition += speed;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public int getxPosition() {
		return this.xPosition;
	}

	public int getyPosition() {
		return this.yPosition;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
