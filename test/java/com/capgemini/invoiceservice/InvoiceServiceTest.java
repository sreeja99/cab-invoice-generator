package com.capgemini.invoiceservice;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator=null;
	@Before
	public void setUp() throws Exception {
		invoiceGenerator=new InvoiceGenerator();
	}
	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
		double distance=2.0;
		int time=5;
		double fare = invoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(25,fare,0.0);
	}
	@Test
	public void givenLessDistanceOrTimeShouldReturnMinFare() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
		double distance=0.1;
		int time=1;
		double fare = invoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(5,fare,0.0);
	}
	@Test
	public void givenMultipleRidesReturnTotalFare() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
		Ride[] rides= {
				new Ride(2.0,5),
				new Ride(0.1,1)
		};
		InvoiceSummary summary=invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedSummary=new InvoiceSummary(2,30.0);
		Assert.assertEquals(expectedSummary,summary);
	}
	@Test
	public void givenUserIdReturnInvoice() {
		int user_id = 2;
		RideRepository rideRepository = new RideRepository();
		Ride[] rideList = rideRepository.getRideList(user_id);
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rideList);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 65.0);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}
