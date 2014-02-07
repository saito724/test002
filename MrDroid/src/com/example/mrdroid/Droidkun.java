package com.example.mrdroid;

import javax.microedition.khronos.opengles.GL10;

public class Droidkun {

	private float size;

	private int point;
	private float speed;
	private float xPosition;
	private int yPosition;

	private int tex_id;

	public Droidkun(int tex_id, int point, float speed, float size,
			float xPosition) {
		super();

		this.yPosition = 0;

		this.tex_id = tex_id;
		this.point = point;
		this.size = size;
		this.speed = speed;
		this.xPosition = xPosition;

	}

	public void draw(GL10 gl) {
		TextureDrawer.drawTexture(gl, tex_id, xPosition, yPosition, (int) size,
				(int) size, 0.0f, 1.0f, 1.0f);
	}

	/**
	 */
	public void fail() {
		this.yPosition += speed;
	}

	public boolean isHit(float x1, float y1, float x2, float y2) {
		return false;
	}

	public enum DroidType {
		type1(R.drawable.ic_launcher, 10, 1.0f, 30.0f), type2(
				R.drawable.ic_launcher, 15, 1.0f, 40.0f), type3(
				R.drawable.ic_launcher, 20, 1.5f, 10.0f), type4(
				R.drawable.ic_launcher, 25, 1.0f, 30.0f), type5(
				R.drawable.ic_launcher, 30, 1.0f, 50.0f);

		private int image_id;
		private int point;
		private float size;
		private float speed;

		
		private DroidType(int image_id, int point, float speed, float size) {
			this.image_id = image_id;
			this.point = point;
			this.speed = speed;
			this.size = size;
		}

		public int getImageId() {
			return image_id;
		}

		public int getPoint() {
			return point;
		}

		public float getSpeed() {
			return speed;
		}

		public float getSize() {
			return size;
		}
		

	}

}
