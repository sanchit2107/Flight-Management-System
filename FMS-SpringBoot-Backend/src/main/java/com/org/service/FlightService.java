package com.org.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.org.model.Flight;

public interface FlightService {
	public ResponseEntity<?> addFlight(Flight flight);

	public Iterable<Flight> viewAllFlight();

	public Flight viewFlight(BigInteger flightNumber);

	public Flight modifyFlight(Flight flight);

	public String removeFlight(BigInteger flightNumber);

}
