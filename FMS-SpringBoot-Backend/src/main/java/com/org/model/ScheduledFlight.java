package com.org.model;

public class ScheduledFlight {
	
	private Flight flightObj;
	
	private int availableSeats;

	//private Schedule schedule;
	
	public ScheduledFlight() {
		
	}
	public ScheduledFlight(Flight flightObj, int availableSeats) {
		super();
		this.flightObj = flightObj;
		this.availableSeats = availableSeats;
		//this.schedule = schedule;
	}
	public Flight getFlight() {
		return flightObj;
	}
	public void setFlight(Flight flightObj) {
		this.flightObj = flightObj;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	/*public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}*/
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
