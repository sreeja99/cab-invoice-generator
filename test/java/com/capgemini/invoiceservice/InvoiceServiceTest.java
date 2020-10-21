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
		String typOfRide="normal";
		double fare = invoiceGenerator.calculateFare(distance,time,typOfRide);
		Assert.assertEquals(25,fare,0.0);
	}
	@Test
	public void givenLessDistanceOrTimeShouldReturnMinFare() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
		double distance=0.1;
		int time=1;
		String typOfRide="normal";
		double fare = invoiceGenerator.calculateFare(distance,time,typOfRide);
		Assert.assertEquals(5,fare,0.0);
	}
	@Test
	public void givenMultipleRidesReturnTotalFare() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
		Ride[] rides= {
				new Ride(2.0,5,"normal"),
				new Ride(0.1,1,"normal")
		};
		InvoiceSummary summary=invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedSummary=new InvoiceSummary(2,30.0);
		Assert.assertEquals(expectedSummary,summary);
	}
	@Test
	public void givenUserIdReturnInvoice() {
		int user_id = 3;
		RideRepository rideRepository = new RideRepository();
		Ride[] rideList = rideRepository.getRideList(user_id);
		InvoiceSummary Summary = invoiceGenerator.calculateFare(rideList);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 110.0);
		Assert.assertEquals(expectedSummary, Summary);
	}
}
