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

	@Before
	public void initializer() {
		invoiceService = new InvoiceService();
	}

	@Test
	public void givenDistanceTime_shouldReturnTotalFare() {
		double distance = 5.0;
		double time = 2.0;
		double fare = InvoiceService.calculateFare(distance, time);
		Assert.assertEquals(52, fare, 0.0);
	}

	@Test
	public void ifTotalFareLessThan5_ReturnTotalFareAs5() {
		double distance = 0.1;
		double time = 2.0;
		double fare = InvoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(5.0, 6), new Ride(0.1, 2) };
		InvoiceSummary actualSummary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(3, 86);
		Assert.assertEquals(expectedSummary, actualSummary);
	}

	@Test
	public void givenUserIdAndRidesShouldReturnInvoiceSummary() {
		String userId = "user@id.com";
		Ride[] rides = { new Ride(2.5, 5), new Ride(0.2, 1) };
		invoiceService.addRides(userId, rides);
		InvoiceSummary actualInvoiceSummary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 35);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

}
