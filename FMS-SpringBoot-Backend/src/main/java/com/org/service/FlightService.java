package com.org.service;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.org.dao.FlightDao;
import com.org.model.Flight;

@Service
public class FlightService 
{
	@Autowired
FlightDao flightDao;
	public String addFlight(Flight flight)
	{
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		if (!findById.isPresent())
		{
			flightDao.save(flight);
			return "Flight added";
	    }
		return "Flight already exists";
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
	public String modifyFlight(@RequestBody Flight flight)
	{
		Optional<Flight> findById=flightDao.findById(flight.getFlightNo());
		if (findById.isPresent()) 
		{
			flightDao.save(flight);
			return "Flight updated";
		}
		return "Flight Not present";
	}
	public  String removeFlight(BigInteger flightNumber)
	{
		Optional<Flight> findById=flightDao.findById(flightNumber);
		if (findById.isPresent())
		{
		flightDao.deleteById(flightNumber);
		return "Flight removed";
	    }
		return "Flight not present";
	}
}
