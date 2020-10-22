package com.bridgelabz.invoicegenerator;

public class InvoiceService {

	private static final double FARE_PER_KM = 10.0;
	private static final double FARE_PER_MIN = 1.0;
	private static final double MINIMUM_FARE = 5;
	private RideRepository rideRepository;

	public InvoiceService() {
		rideRepository = new RideRepository();
	}

	public static double calculateFare(double distance, double time) {
		double fare = distance * FARE_PER_KM + time * FARE_PER_MIN;
		if (fare > MINIMUM_FARE)
			return fare;
		else
			return MINIMUM_FARE;
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		double avFare = 0;
		for (Ride ride : rides)
			totalFare += this.calculateFare(ride.distance, ride.time);
		return new InvoiceSummary(rides.length, totalFare);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return calculateFare(rideRepository.getUserRides(userId));
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addUserRide(userId, rides);
	}

}
