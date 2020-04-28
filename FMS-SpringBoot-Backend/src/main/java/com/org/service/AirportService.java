package com.org.service;

import java.util.Optional;

import com.org.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.AirportDao;

@Service
public class AirportService 
{
	@Autowired
	AirportDao airportDao;
	public Iterable<Airport> viewAllAirport()
	{
	    return airportDao.findAll();
	}
	public Airport viewAirport(String airportCode)
	{
		Optional<Airport> findById=airportDao.findById(airportCode);
		return findById.get();
	}
}
