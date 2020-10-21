package com.capgemini.invoiceservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceGenerator {

	private static final double COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;
	private static final double COST_PER_KILOMETER_PREMIUM = 15.0;
	private static final int COST_PER_TIME_PREMIUM = 2;
	private static final double MINIMUM_FARE_PREMIUM = 20.0;

	public double calculateFare(double distance, int time,String typOfRide ) {
		if (typOfRide.equals("normal")) {
			double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_TIME;
			return Math.max(totalFare, MINIMUM_FARE);
		}
		if(typOfRide.equals("premium")) {
			double totalFare = distance * COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
			return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
		}
		return 0;
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		int numOfRides=0;
		double totalFare=0;
		for(Ride ride:rides) {
			numOfRides++;
			totalFare+=this.calculateFare(ride.distance,ride.time,ride.typOfride);
		}
		return new InvoiceSummary(rides.length,totalFare);
	}
	
}
