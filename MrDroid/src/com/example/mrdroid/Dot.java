package com.example.mrdroid;

import android.util.Log;

public class Dot {
	float place;
	float maxLimit;
	float minLimit;

	// 成長していく方向（trueならプラス）
	boolean vector = false;

	
	public Dot(float place, float maxLimit, float minLimit, boolean vector) {
		super();
		this.place = place;
		this.maxLimit = maxLimit;
		this.minLimit = minLimit;
		this.vector = vector;
	}

	public void update(float speed) {
		Log.d("update","方向"+place+"vector"+vector);
		if (this.vector) {// +方向に進んでいる
			place += speed;
			if (place >= maxLimit) {
				place = maxLimit;
				vector = false;
			}
		} else {
			place -= speed;
			if (place <= minLimit) {
				place = minLimit;
				vector = true;
			}			
		}
	}

	public float getPlace() {
		return place;
	}

	public void setPlace(float place) {
		this.place = place;
	}

	public float getMinLimit() {
		return minLimit;
	}

	public void setMinLimit(float minLimit) {
		this.minLimit = minLimit;
	}

	public float getMaxLImit() {
		return maxLimit;
	}

	public void setMaxLImit(float maxLimit) {
		this.maxLimit = maxLimit;
	}

	public boolean isVector() {
		return vector;
	}

	public void setVector(boolean vector) {
		this.vector = vector;
	}

}
