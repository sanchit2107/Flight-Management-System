package com.org.service;

import com.org.model.Airport;

public interface AirportService {
	public Iterable<Airport> viewAllAirport();

	public Airport viewAirport(String airportCode);

	public void addAirport(Airport airport);

	public void modifyAirport(Airport airport);

	public void removeAirport(String airportCode);
}
