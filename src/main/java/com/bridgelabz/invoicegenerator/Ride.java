package com.bridgelabz.invoicegenerator;

public class Ride {

	public double distance;
	public CabRide cabRideType;
	public int timeInMinute;

	public Ride(CabRide cabRideType, double distance, int timeInMinute) {
		this.distance = distance;
		this.timeInMinute = timeInMinute;
		this.cabRideType = cabRideType;
	}

}
