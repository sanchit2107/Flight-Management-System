package com.org.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ScheduledFlight {
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flightNo")
	private Flight flightObj;
	
	private int availableSeats;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sourceAirport")
	private Schedule schedule;
	
	public ScheduledFlight() {
		
	}
	public ScheduledFlight(Flight flightObj, int availableSeats, Schedule schedule) {
		super();
		this.flightObj = flightObj;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	/**
	 * @return the flightObj
	 */
	public Flight getFlightObj() {
		return flightObj;
	}
	/**
	 * @param flightObj the flightObj to set
	 */
	public void setFlightObj(Flight flightObj) {
		this.flightObj = flightObj;
	}
	
	

}
