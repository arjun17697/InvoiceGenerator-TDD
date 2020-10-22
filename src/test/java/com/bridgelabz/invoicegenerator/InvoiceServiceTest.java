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
}
