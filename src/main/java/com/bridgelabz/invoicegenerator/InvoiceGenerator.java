package com.bridgelabz.invoicegenerator;

public class InvoiceGenerator {

	private static final double FARE_PER_KM = 10.0;
	private static final double FARE_PER_MIN = 1.0;

	public static double calculateFare(double distance, double time) {
		return distance*FARE_PER_KM + time*FARE_PER_MIN;
	}

}
