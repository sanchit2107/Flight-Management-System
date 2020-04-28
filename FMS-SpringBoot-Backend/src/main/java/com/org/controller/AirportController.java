package com.org.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Airport;
import com.org.service.AirportService;
@RestController
@RequestMapping("/view")
public class AirportController
{
	@Autowired(required=true)
	AirportService airportService;
	@RequestMapping("/viewAirport/{id}")
	public Airport viewAirport(@PathVariable("id") String airportCode)
	{
	    return airportService.viewAirport(airportCode);	
	}
	@RequestMapping("/allAirport")
	public Iterable<Airport> viewAllAirport()
	{
		return airportService.viewAllAirport();
	}
}
