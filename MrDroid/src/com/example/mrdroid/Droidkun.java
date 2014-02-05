package com.example.mrdroid;

public class Droidkun {

	private int width;
	private int height;

	private int xPosition;
	private int yPosition;
	private int speed;

	public Droidkun(int width, int height, int xPosition, int speed) {
		super();
		this.width = width;
		this.height = height;
		this.xPosition = xPosition;
		this.speed = speed;
		
		
		this.yPosition = 0;
	}

	/**
	 * 
	 */
	public void fail(){
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
