package com.bridgelabz.invoicegenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class InvoiceServiceTest {
	/**
	 * Rigorous Test :-)
	 */

	InvoiceService invoiceService;
	RideRepository rideRepository;

	@Before
	public void initializer() {
		invoiceService = new InvoiceService();
		rideRepository = new RideRepository();
	}

	@Test
	public void givenDistanceTime_shouldReturnTotalFare() {
		double distance = 5.0;
		double time = 2.0;
		double fare = InvoiceService.calculateFarePerRide(distance, time);
		Assert.assertEquals(52, fare, 0.0);
	}

	@Test
	public void ifTotalFareLessThan5_ReturnTotalFareAs5() {
		double distance = 0.1;
		double time = 2.0;
		double fare = InvoiceService.calculateFarePerRide(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenUserIdAndRides_ForNormaAndPremimum_ShouldReturnInvoiceSummary() {
		String userId = "user@id.com";
		Ride[] rides = { new Ride(CabRide.PREMIUM, 2, 5), new Ride(CabRide.NORMAL, 0.2, 1),
				new Ride(CabRide.NORMAL, 5, 5) };
		invoiceService.setRideRepository(rideRepository);
		invoiceService.addRides(userId, rides);
		InvoiceSummary actualInvoiceSummary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 100);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

}
