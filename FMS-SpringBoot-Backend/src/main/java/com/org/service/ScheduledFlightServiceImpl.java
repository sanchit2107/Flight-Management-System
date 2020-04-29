package com.org.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.dao.ScheduledFlightDao;
import com.org.exceptions.ScheduledFlightAlreadyPresentException;
import com.org.exceptions.ScheduledFlightNotFoundException;
import com.org.model.ScheduledFlight;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {
	
	/*
	 Creating DAO object
	 */
	@Autowired
	ScheduledFlightDao dao;
	
	
	/*
	 Service method to add new Scheduled flight to database
	 */
	@Override
	public ResponseEntity<?> addScheduledFlight(ScheduledFlight scheduledFlight) {
		Optional<ScheduledFlight> find= dao.findById(scheduledFlight.getId());
		try{
			if(!find.isPresent()) {
				dao.save(scheduledFlight);
				return new ResponseEntity<ScheduledFlight>(scheduledFlight, HttpStatus.OK);
			}
			else 
				throw new ScheduledFlightAlreadyPresentException("Record is already present in database");
		}catch(ScheduledFlightAlreadyPresentException e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	
	/*
	 Service method to modify existing Scheduled flight in database
	 */
	@Override
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) {
		Optional<ScheduledFlight> find= dao.findById(scheduledFlight.getId());
		if(find.isPresent()) {
			ScheduledFlight sf= find.get();
			sf.setArrivalTime(scheduledFlight.getArrivalTime());
			sf.setDepartureTime(scheduledFlight.getDepartureTime());
			sf.setAvailableSeats(scheduledFlight.getAvailableSeats());
		}
		return scheduledFlight;
	}
	
	
	/*
	 Service method to remove existing Scheduled flight from database
	 */
	@Override
	public String removeScheduledFlight(BigInteger id) {
		Optional<ScheduledFlight> find= dao.findById(id);
		if(find.isPresent()) {
			dao.deleteById(id);
			return "Scheduled flight with ID "+id+" is removed";
		}
		return "Scheduled flight with ID "+id+" is not found";
	}
	
	
	/*
	 Service method to view all Scheduled flights in database
	 */
	@Override
	public Iterable<ScheduledFlight> viewAllScheduledFlights(){
		return dao.findAll();
	}
	
	
	/*
	 Service method to view a Scheduled flight by ID from database
	 */
	@Override
	public ResponseEntity<?> viewScheduledFlight(BigInteger id) {
		Optional<ScheduledFlight> find= dao.findById(id);
		try{
			if(find.isPresent()) {
				ScheduledFlight sf= find.get();
				return new ResponseEntity<ScheduledFlight>(sf, HttpStatus.OK);
			}
			else
				throw new ScheduledFlightNotFoundException("No record found with ID "+id);
		}catch(ScheduledFlightNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
