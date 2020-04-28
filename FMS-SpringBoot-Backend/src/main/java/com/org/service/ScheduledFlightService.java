package com.org.service;

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
		Optional<ScheduledFlight> find= dao.findById(scheduledFlight.getFlightObj());
		if(!find.isPresent()) {
			dao.save(scheduledFlight);
		}
	}
	
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) {
		Optional<ScheduledFlight> find= dao.findById(scheduledFlight.getFlightObj());
		if(find.isPresent()) {
			ScheduledFlight sf= find.get();
			sf.setSchedule(scheduledFlight.getSchedule());
			sf.setAvailableSeats(scheduledFlight.getAvailableSeats());
		}
		return scheduledFlight;
	}
	
	public void removeScheduledFlight(ScheduledFlight scheduledFlight) {
		Optional<ScheduledFlight> find= dao.findById(scheduledFlight.getFlightObj());
		if(find.isPresent()) 
			dao.delete(scheduledFlight);
	}
	
	public Iterable<ScheduledFlight> viewScheduledFlights(){
		return dao.findAll();
	}
	
	public ScheduledFlight viewScheduledFlight(ScheduledFlight scheduledFlight) {
		Optional<ScheduledFlight> find= dao.findById(scheduledFlight.getFlightObj());
		if(!find.isPresent())
			return null;
		return find.get();
	}

}
