package com.org.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Schedule {
	private Airport sourceAirport;
	private Airport destinationAirport;
	private Date arrivalTime;
	private Date departureTime;
	
	@OneToOne(mappedBy = "schedule")
	private ScheduledFlight scheduleFlightObj;
	
	public Schedule() {
		
	}
	
	public Schedule(Airport sourceAirport, Airport destinationAirport, Date arrivalTime, Date departureTime) {
		super();
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
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

	/**
	 * @return the scheduleFlightObj
	 */
	public ScheduledFlight getScheduleFlightObj() {
		return scheduleFlightObj;
	}

	/**
	 * @param scheduleFlightObj the scheduleFlightObj to set
	 */
	public void setScheduleFlightObj(ScheduledFlight scheduleFlightObj) {
		this.scheduleFlightObj = scheduleFlightObj;
	}
	
	
}
