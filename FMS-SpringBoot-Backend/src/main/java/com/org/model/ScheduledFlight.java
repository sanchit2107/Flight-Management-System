package com.org.model;


import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class ScheduledFlight {
	
	@Id
	private BigInteger id;
	
	@OneToOne
	@JoinColumn
	@MapsId
	private Flight flightObj;
	
	private int availableSeats;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "airportCode")
//	private Airport sourceAirport;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "airportCode")
//	private Airport destinationAirport;
	
	private Date arrivalTime;
	private Date departureTime;
	
	public ScheduledFlight() {
		
	}

	public ScheduledFlight(BigInteger id, int availableSeats, Date arrivalTime, Date departureTime) {
		super();
		this.id = id;
		this.availableSeats = availableSeats;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
//	public Airport getSourceAirport() {
//		return sourceAirport;
//	}
//
//	public void setSourceAirport(Airport sourceAirport) {
//		this.sourceAirport = sourceAirport;
//	}

//	public Airport getDestinationAirport() {
//		return destinationAirport;
//	}
//
//	public void setDestinationAirport(Airport destinationAirport) {
//		this.destinationAirport = destinationAirport;
//	}

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
