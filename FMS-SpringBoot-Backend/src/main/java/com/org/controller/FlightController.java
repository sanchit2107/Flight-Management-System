package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.org.model.Flight;
import com.org.service.FlightServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flight")
<<<<<<< HEAD
public class FlightController {
	@Autowired(required = true)
	FlightService flightService;

	@PostMapping("/addFlight")
	public void addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight);
=======
public class FlightController
{
	@Autowired(required=true)
FlightServiceImpl flightServiceImpl;
	@PostMapping("/addFlight")
	public void addFlight(@RequestBody Flight flight)
	{
		flightServiceImpl.addFlight(flight);
>>>>>>> parent of f09bb40... Controller updated
	}

	@RequestMapping("/allFlight")
<<<<<<< HEAD
	public Iterable<Flight> viewAllFlight() {
		return flightService.viewAllFlight();
=======
	public Iterable<Flight> viewAllFlight()
	{
		return flightServiceImpl.viewAllFlight();
>>>>>>> parent of f09bb40... Controller updated
	}

	@RequestMapping("/viewFlight/{id}")
<<<<<<< HEAD
	public Flight viewFlight(@PathVariable("id") BigInteger flightNo) {
		return flightService.viewFlight(flightNo);
	}

	@PutMapping("/updateFlight")
	public void modifyFlight(@RequestBody Flight flight) {
		flightService.modifyFlight(flight);
=======
	public Flight viewAirport(@PathVariable("id") BigInteger flightNo)
	{
	    return flightServiceImpl.viewFlight(flightNo);	
	}
	@PutMapping("/updateFlight/")
	public void modifyFlight(@RequestBody Flight flight)
	{
		flightServiceImpl.modifyFlight(flight);
>>>>>>> parent of f09bb40... Controller updated
	}

	@DeleteMapping("/deleteFlight/{id}")
<<<<<<< HEAD
	public void removeFlight(@PathVariable("id") BigInteger flightNo) {
		flightService.removeFlight(flightNo);
=======
	public void removeFlight(@PathVariable("id") BigInteger flightNo)
	{
		flightServiceImpl.removeFlight(flightNo);
>>>>>>> parent of f09bb40... Controller updated
	}
}
