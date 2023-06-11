package com.java.net.entity;

/*
 * Author Rajesh kumar
 * */


public class Wind {
    private Double speed;
    private int deg;
    private Double gust;
    
    
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public int getDeg() {
		return deg;
	}
	public void setDeg(int deg) {
		this.deg = deg;
	}
	public Double getGust() {
		return gust;
	}
	public void setGust(Double gust) {
		this.gust=gust;
	}
	public Wind(Double speed, int deg, Double gust) {
		super();
		this.speed = speed;
		this.deg = deg;
		this.gust = gust;
	}
	public Wind() {
		super();
	}
    
    
}

