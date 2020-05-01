package com.org.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Schedule {
	@EmbeddedId
	private ScheduleId scheduleId;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date arrivalTime;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date departureTime;
	
	@OneToOne(mappedBy = "schedule")
	private ScheduledFlight sFLight;
	
	/*
	 Default constructor
	 */
	public Schedule() {
		
	}
	
	
	/*
	 Parameterized constructor
	 */
	public Schedule(ScheduleId scheduleId, Date arrivalTime, Date departureTime) {
		super();
		this.scheduleId = scheduleId;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	
	public ScheduleId getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(ScheduleId scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime 
			//	+ ", sFLight=" + sFLight 
				+ "]";
	}
	
	

}
