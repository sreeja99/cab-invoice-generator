package com.capgemini.invoiceservice;

public class Ride {
	public double distance;
	public int time;
	public String typOfride;

	public Ride(double distance,int time,String typOfride) {
		this.distance=distance;
		this.time=time;
		this.typOfride=typOfride;
	}
}
