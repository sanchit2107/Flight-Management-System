package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.ScheduledFlight;
import com.org.service.ScheduledFlightService;

@RestController
@RequestMapping("/scheduledFlight")
public class ScheduledFlightController {
	
	@Autowired
	ScheduledFlightService service;
	
	@PostMapping("/add")
	public void addSF(@RequestBody ScheduledFlight scheduledFlight) {
		service.addScheduledFlight(scheduledFlight);
	}
	
	@PutMapping("/modify")
	public ScheduledFlight modifySF(@RequestBody ScheduledFlight scheduledFlight) {
		return service.modifyScheduledFlight(scheduledFlight);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSF(@PathVariable("id") BigInteger id) {
		service.removeScheduledFlight(id);
	}
	
	@GetMapping("/view/{id}")
	public ScheduledFlight viewSF(@PathVariable("id") BigInteger id) {
		return service.viewScheduledFlight(id);
	}

	@GetMapping("/viewAll")
	public Iterable<ScheduledFlight> viewAllSF() {
		return service.viewAllScheduledFlights();
	}

}
