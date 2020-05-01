package com.org.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.dao.ScheduleDao;
import com.org.exceptions.ScheduleAlreadyPresentException;
import com.org.exceptions.ScheduleNotFoundException;
import com.org.model.Schedule;
import com.org.model.ScheduleId;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	/*
	 Creating DAO object
	 */
	@Autowired
	ScheduleDao dao;
	
	
	/*
	 Service method to add new Schedule to database
	 */
	@Override
	public ResponseEntity<?> addSchedule(Schedule schedule) {
		Optional<Schedule> find= dao.findById(schedule.getScheduleId());
		try{
			if(!find.isPresent()) {
				dao.save(schedule);
				return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
			}
			else 
				throw new ScheduleAlreadyPresentException("Record is already present in database");
		}catch(ScheduleAlreadyPresentException e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	
	/*
	 Service method to modify existing Schedule in database
	 */
	@Override
	public Schedule modifySchedule(Schedule schedule) {
		Optional<Schedule> find= dao.findById(schedule.getScheduleId());
		if(find.isPresent()) {
			dao.save(schedule);
		}
		return schedule;
	}

	
	/*
	 Service method to remove existing Schedule from database
	 */
	@Override
	public String removeSchedule(ScheduleId id) {
		Optional<Schedule> find= dao.findById(id);
		if(find.isPresent()) {
			dao.deleteById(id);
			return "Schedule with ID "+id+" is removed";
		}
		return "Schedule with ID "+id+" is not found";
	}

	
	/*
	 Service method to view all Schedules in database
	 */
	@Override
	public Iterable<Schedule> viewAllSchedules() {
		return dao.findAll();
	}

	
	/*
	 Service method to view a Schedule by ID from database
	 */
	@Override
	public ResponseEntity<?> viewSchedule(ScheduleId id) {
		Optional<Schedule> find= dao.findById(id);
		try{
			if(find.isPresent()) {
				Schedule s= find.get();
				return new ResponseEntity<Schedule>(s, HttpStatus.OK);
			}
			else
				throw new ScheduleNotFoundException("No record found with ID "+id);
		}catch(ScheduleNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
