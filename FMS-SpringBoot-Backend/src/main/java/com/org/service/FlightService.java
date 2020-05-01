package com.org.service;

import java.math.BigInteger;

import com.org.model.Flight;

public interface FlightService {
	public void addFlight(Flight flight);

	public Iterable<Flight> viewAllFlight();

	public Flight viewFlight(BigInteger flightNumber);

	public void modifyFlight(Flight flight);

	public void removeFlight(BigInteger flightNumber);

}
