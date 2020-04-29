package com.org.controller;

import java.math.BigInteger;

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
import com.org.service.FlightServiceImpl;

@RestController
@RequestMapping("/flight")
public class FlightController
{
	@Autowired(required=true)
FlightServiceImpl flightServiceImpl;
	@PostMapping("/addFlight")
	public void addFlight(@RequestBody Flight flight)
	{
		flightServiceImpl.addFlight(flight);
	}
	@RequestMapping("/allFlight")
	public Iterable<Flight> viewAllFlight()
	{
		return flightServiceImpl.viewAllFlight();
	}
	@RequestMapping("/viewFlight/{id}")
	public Flight viewAirport(@PathVariable("id") BigInteger flightNo)
	{
	    return flightServiceImpl.viewFlight(flightNo);	
	}
	@PutMapping("/updateFlight/")
	public void modifyFlight(@RequestBody Flight flight)
	{
		flightServiceImpl.modifyFlight(flight);
	}
	@DeleteMapping("/deleteFlight/{id}")
	public void removeFlight(@PathVariable("id") BigInteger flightNo)
	{
		flightServiceImpl.removeFlight(flightNo);
	}
}
