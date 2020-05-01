package com.org.model;


import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
public class ScheduledFlight {
	
	@Id
	@Column(name = "ID")
	private BigInteger id;
	
	@OneToOne
	@JoinColumn(name="id")
	@MapsId
	private Flight flight;
	
	private int availableSeats;
	
	
	@OneToOne
	@JoinColumn(name = "sourceAirport")
	@JoinColumn(name = "destinationAirport")
	private Schedule schedule;

	/*
	 Default constructor
	 */
	public ScheduledFlight() {
		
	}
	
	
	/*
	 Parameterized constructor
	 */
	public ScheduledFlight(BigInteger id, int availableSeats, Flight flight, Schedule schedule) {
		super();
		this.id = id;
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}

	
	/*
	 Getter and setter for ID 
	 */
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	/*
	 Getter and setter for Available seats
	 */
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	/*
	 Getter and setter for Flight object
	 */
	public Flight getFlightObj() {
		return flight;
	}
	public void setFlightObj(Flight flight) {
		this.flight = flight;
	}

	
	/*
	 Getter and setter for Schedule object
	 */
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
}
