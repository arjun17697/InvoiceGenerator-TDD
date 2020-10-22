package com.bridgelabz.invoicegenerator;

public class InvoiceGenerator {

	private static final double FARE_PER_KM = 10.0;
	private static final double FARE_PER_MIN = 1.0;

	public static double calculateFare(double distance, double time) {
		double fare = distance * FARE_PER_KM + time * FARE_PER_MIN;
		if (fare > 5)
			return fare;
		else
			return 5;
	}

}
