package com.capgemini.invoiceservice;

import java.util.HashMap;

public class RideRepository {
	HashMap<Integer, Ride[]> ridesMapUserId = new HashMap<>();

	public RideRepository() {
		Ride[] rides1 = { new Ride(2.0, 5,"premium"), new Ride(0.1, 1,"premuim") };
		ridesMapUserId.put(1, rides1);
		Ride[] rides2 = { new Ride(6.0, 10,"normal"), new Ride(0.1, 1,"premuim") };
		ridesMapUserId.put(2, rides2);
		Ride[] rides3 = { new Ride(8.0, 10,"normal"), new Ride(0.1, 1,"premium") };
		ridesMapUserId.put(3, rides3);
	}

	public Ride[] getRideList(int user_id) {
		return ridesMapUserId.get(user_id);
	}

}
