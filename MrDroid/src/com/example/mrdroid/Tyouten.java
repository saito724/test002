package com.example.mrdroid;

import android.util.Log;



public class Tyouten {

	Dot[] dots;
	float[] points;

	public Tyouten(Dot x1, Dot y1,Dot x2, Dot y2,Dot x3, Dot y3) {
		super();
		 points = new float[6];
		this.dots = new Dot[]{x1,y1,x2,y2,x3,y3};
	}

	public void updateDots(float speed){
		for(Dot d :dots){
			d.update(speed);
		}
	}
	
	public float[] getPoints(){

         for (int i = 0 ; i < dots.length; i++) {
			points[i] = dots[i].getPlace();
		}
		return this.points;
	}
	

}
