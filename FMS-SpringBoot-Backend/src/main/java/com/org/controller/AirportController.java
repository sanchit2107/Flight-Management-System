package com.org.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("http://localhost:4200")
@RestController
<<<<<<< HEAD
@RequestMapping("/airport")
public class AirportController {
	@Autowired(required = true)
	AirportService airportService;

	@RequestMapping("/viewAirport/{id}")
	public Airport viewAirport(@PathVariable("id") String airportCode) {
		return airportService.viewAirport(airportCode);
=======
@RequestMapping("/view")
public class AirportController
{
	@Autowired(required=true)
	AirportServiceImpl airportServiceImpl;
	@RequestMapping("/viewAirport/{id}")
	public Airport viewAirport(@PathVariable("id") String airportCode)
	{
	    return airportServiceImpl.viewAirport(airportCode);	
>>>>>>> parent of f09bb40... Controller updated
	}

	@RequestMapping("/allAirport")
<<<<<<< HEAD
	public Iterable<Airport> viewAllAirport() {
		return airportService.viewAllAirport();
=======
	public Iterable<Airport> viewAllAirport()
	{
		return airportServiceImpl.viewAllAirport();
>>>>>>> parent of f09bb40... Controller updated
	}

	@PostMapping("/addAirport")
<<<<<<< HEAD
	public void addAirport(@RequestBody Airport airport) {
		airportService.addAirport(airport);
=======
	public void addAirport(Airport airport)
	{
		airportServiceImpl.addAirport(airport);
>>>>>>> parent of f09bb40... Controller updated
	}

	@PutMapping("/updateAirport")
<<<<<<< HEAD
	public void modifyAirport(@RequestBody Airport airport) {
		airportService.modifyAirport(airport);
=======
	public void modifyAirport(Airport airport)
	{
		airportServiceImpl.modifyAirport(airport);
>>>>>>> parent of f09bb40... Controller updated
	}

	@DeleteMapping("/deleteAirport/{id}")
<<<<<<< HEAD
	public void removeAirport(@PathVariable("id") String airportCode) {
		airportService.removeAirport(airportCode);
=======
	public void removeAirport(@PathVariable("id")String airportCode)
	{
		airportServiceImpl.removeAirport(airportCode);
>>>>>>> parent of f09bb40... Controller updated
	}
}
