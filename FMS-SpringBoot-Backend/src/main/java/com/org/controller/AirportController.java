package com.org.controller;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Airport;
import com.org.model.Flight;
import com.org.service.AirportServiceImpl;
@RestController
@RequestMapping("/view")
public class AirportController
{
	@Autowired(required=true)
	AirportServiceImpl airportServiceImpl;
	@RequestMapping("/viewAirport/{id}")
	public Airport viewAirport(@PathVariable("id") String airportCode)
	{
	    return airportServiceImpl.viewAirport(airportCode);	
	}
	@RequestMapping("/allAirport")
	public Iterable<Airport> viewAllAirport()
	{
		return airportServiceImpl.viewAllAirport();
	}
	@PostMapping("/addAirport")
	public void addAirport(Airport airport)
	{
		airportServiceImpl.addAirport(airport);
	}
	@PutMapping("/updateAirport")
	public void modifyAirport(Airport airport)
	{
		airportServiceImpl.modifyAirport(airport);
	}
	@DeleteMapping("/deleteAirport/{id}")
	public void removeAirport(@PathVariable("id")String airportCode)
	{
		airportServiceImpl.removeAirport(airportCode);
	}
}
