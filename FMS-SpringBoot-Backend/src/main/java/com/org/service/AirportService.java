package com.org.service;

import java.util.Optional;

import com.org.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.AirportDao;
import com.org.exceptions.RecordNotFoundException;

@Service
public class AirportService 
{
	@Autowired
	AirportDao airportDao;
	/*
	 * view all Airports
	 */
	public Iterable<Airport> viewAllAirport()
	{
	    return airportDao.findAll();
	}
	/*
	 * view airport by airportCode
	 */
	public Airport viewAirport(String airportCode)
	{
		Optional<Airport> findById=airportDao.findById(airportCode);
		if(findById.isPresent())
		{
		return findById.get();
	    }
		else
			throw new RecordNotFoundException("Airport with airport code: "+airportCode+"not exists");
    }
}
