package com.capgemini.invoiceservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceGenerator {

	private static final double COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double totalFare = distance*COST_PER_KILOMETER+time*COST_PER_TIME;
		if(totalFare<MINIMUM_FARE)
			return MINIMUM_FARE;
		return totalFare;
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		int numOfRides=0;
		double totalFare=0;
		for(Ride ride:rides) {
			numOfRides++;
			totalFare+=this.calculateFare(ride.distance,ride.time);
		}
		return new InvoiceSummary(rides.length,totalFare);
	}
	
}
