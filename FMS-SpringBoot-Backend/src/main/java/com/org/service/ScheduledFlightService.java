package com.org.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.org.model.ScheduledFlight;

public interface ScheduledFlightService {
	
	public ResponseEntity<?> addScheduledFlight(ScheduledFlight scheduledFlight);
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);
	public String removeScheduledFlight(BigInteger id);
	public Iterable<ScheduledFlight> viewAllScheduledFlights();
	public ResponseEntity<?> viewScheduledFlight(BigInteger id);

}
