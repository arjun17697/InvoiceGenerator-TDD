package com.bridgelabz.invoicegenerator;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class InvoiceServiceTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void givenDistanceTime_shouldReturnTotalFare()
    {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance=5.0;
		double time=2.0;
		double fare=InvoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(52, fare, 0.0);
    }
   
    @Test
    public void ifTotalFareLessThan5_ReturnTotalFareAs5()
    {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance=0.1;
		double time=2.0;
		double fare=InvoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(5, fare, 0.0);
    }
    
    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
    	InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    	Ride[] rides= {	new Ride(2.0,5),
    					new Ride(5.0,6),
    					new Ride(0.1,2)
    					};
    	double fare=invoiceGenerator.calculateFare(rides);
    	Assert.assertEquals(86,fare,0.0);
    }
}
