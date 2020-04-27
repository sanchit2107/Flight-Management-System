package com.org.service;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.FlightDao;
import com.org.model.Flight;

@Service
public class FlightService 
{
	@Autowired
FlightDao flightDao;
	public void addFlight(Flight flight)
	{
		Optional<Flight> findById = flightDao.findById(flight.getFlightNumber());
		if (!findById.isPresent())
		{
			flightDao.save(flight);
	    }
	}
	public Iterable<Flight> viewAllFlight()
	{
		return flightDao.findAll();
	}
	public Flight viewFlight(BigInteger flightNumber)
	{
		Optional<Flight> findById=flightDao.findById(flightNumber);
		return findById.get();
	}
	public void modifyFlight(Flight flight)
	{
		Optional<Flight> findById=flightDao.findById(flight.getFlightNumber());
		if (findById.isPresent()) 
		{
			flightDao.save(flight);
		}
	}
	public void removeFlight(BigInteger flightNumber)
	{
		flightDao.delete(viewFlight(flightNumber));
	}
	
}
