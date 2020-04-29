package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.exceptions.ScheduledFlightNotFoundException;
import com.org.model.ScheduledFlight;
import com.org.service.ScheduledFlightService;

@RestController
@RequestMapping("/scheduledFlight")
public class ScheduledFlightController {
	/*
	 Creating Service object
	 */
	@Autowired
	ScheduledFlightService service;
	
	
	/*
	 Controller for adding Scheduled Flights
	 */
	@PostMapping("/add")
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<?> addSF(@RequestBody ScheduledFlight scheduledFlight) {
		return service.addScheduledFlight(scheduledFlight);
	}
	
	/*
	 Controller for modifying existing Scheduled Flights
	 */
	@PutMapping("/modify")
	public ScheduledFlight modifySF(@RequestBody ScheduledFlight scheduledFlight) {
		return service.modifyScheduledFlight(scheduledFlight);
	}
	
	
	/*
	 Controller for deleting existing Scheduled Flights
	 */
	@DeleteMapping("/delete/{id}")
	public void deleteSF(@PathVariable("id") BigInteger id) {
		service.removeScheduledFlight(id);
	}
	
	
	/*
	 Controller for viewing a Scheduled Flight by ID
	 */
	@GetMapping("/view/{id}")
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<?> viewSF(@PathVariable("id") BigInteger id) {
		return service.viewScheduledFlight(id);
	}

	
	/*
	 Controller for viewing all Scheduled Flights
	 */
	@GetMapping("/viewAll")
	public Iterable<ScheduledFlight> viewAllSF() {
		return service.viewAllScheduledFlights();
	}

}
