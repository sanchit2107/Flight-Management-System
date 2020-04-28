package com.org.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.ScheduledFlightDao;
import com.org.model.ScheduledFlight;

@Service
public class ScheduledFlightService {
	@Autowired
	ScheduledFlightDao dao;
	
	public void addScheduledFlight(ScheduledFlight scheduledFlight) {
		Optional<ScheduledFlight> find= dao.findById(scheduledFlight.getId());
		if(!find.isPresent()) {
			dao.save(scheduledFlight);
		}
	}
	
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
	
	public void removeScheduledFlight(BigInteger id) {
		Optional<ScheduledFlight> find= dao.findById(id);
		if(find.isPresent()) 
			dao.deleteById(id);
	}
	
	public Iterable<ScheduledFlight> viewAllScheduledFlights(){
		return dao.findAll();
	}
	
	public ScheduledFlight viewScheduledFlight(BigInteger id) {
		Optional<ScheduledFlight> find= dao.findById(id);
		if(!find.isPresent())
			return null;
		return find.get();
	}

}
