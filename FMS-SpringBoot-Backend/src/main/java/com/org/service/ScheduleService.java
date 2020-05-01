package com.org.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.org.model.Schedule;
import com.org.model.ScheduleId;


public interface ScheduleService {
	public ResponseEntity<?> addSchedule(Schedule schedule);
	public Schedule modifySchedule(Schedule schedule);
	public String removeSchedule(ScheduleId id);
	public Iterable<Schedule> viewAllSchedules();
	public ResponseEntity<?> viewSchedule(ScheduleId id);
}
