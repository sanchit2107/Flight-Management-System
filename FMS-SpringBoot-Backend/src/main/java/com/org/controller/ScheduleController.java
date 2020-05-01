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

import com.org.exceptions.ScheduleAlreadyPresentException;
import com.org.exceptions.ScheduleNotFoundException;
import com.org.model.Schedule;
import com.org.model.ScheduleId;
import com.org.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	/*
	 Creating Service object
	 */
	@Autowired 
	ScheduleService service;
	
	/*
	 Controller for adding Schedule
	 */
	@PostMapping("/add")
	@ExceptionHandler(ScheduleAlreadyPresentException.class)
	public ResponseEntity<?> add(@RequestBody Schedule schedule){
		return service.addSchedule(schedule);
	}
	
	/*
	 Controller for viewing all Schedules
	 */
	@GetMapping("/viewAll")
	public Iterable<Schedule> viewAll(){
		return service.viewAllSchedules();
	}
	
	/*
	 Controller for modifying existing Schedule
	 */
	@PutMapping("/update")
	public Schedule update(@RequestBody Schedule schedule) {
		return service.modifySchedule(schedule);
	}
	
	/*
	 Controller for viewing a Scheduled Flight by ID
	 */
	@GetMapping("/view")
	@ExceptionHandler(ScheduleNotFoundException.class)
	public ResponseEntity<?> view(@RequestBody ScheduleId id){
		return service.viewSchedule(id);
	}

	/*
	 Controller for deleting existing Schedule
	 */
	@DeleteMapping("/delete")
	public void deleteSF(@RequestBody ScheduleId id) {
		service.removeSchedule(id);
	}
}
