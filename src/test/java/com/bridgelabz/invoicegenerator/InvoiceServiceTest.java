package com.bridgelabz.invoicegenerator;

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

	InvoiceGenerator invoiceGenerator;

	@Before
	public void initializer() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceTime_shouldReturnTotalFare() {
		double distance = 5.0;
		double time = 2.0;
		double fare = InvoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(52, fare, 0.0);
	}

	@Test
	public void ifTotalFareLessThan5_ReturnTotalFareAs5() {
		double distance = 0.1;
		double time = 2.0;
		double fare = InvoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(5.0, 6), new Ride(0.1, 2) };
		InvoiceSummary actualSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(3, 86);
		Assert.assertEquals(expectedSummary, actualSummary);
	}

}
