package com.org.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Schedule {
	@Id
	@Column(name = "schedule_Id")
	private BigInteger scheduleId;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Airport sourceAirport;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Airport destinationAirport;
	
	@Column(name = "departure_date_time")
	@DateTimeFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private LocalDateTime departureDateTime;
	
	@Column(name = "arrival_date_time")
	@DateTimeFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private LocalDateTime arrivalDateTime;
	
	/*
	 Default constructor
	 */
	public Schedule() {
		
	}
	
	
	/*
	 Parameterized constructor
	 */
	public Schedule(BigInteger scheduleId, Airport sourceAirport, Airport destinationAirport,
			LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
		super();
		this.scheduleId = scheduleId;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
	}

	/*
	 * Getters and setters
	 */
	public BigInteger getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(BigInteger scheduleId) {
		this.scheduleId = scheduleId;
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


	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}


	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}


	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", sourceAirport=" + sourceAirport + ", destinationAirport="
				+ destinationAirport + ", departureDateTime=" + departureDateTime + ", arrivalDateTime="
				+ arrivalDateTime + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalDateTime == null) ? 0 : arrivalDateTime.hashCode());
		result = prime * result + ((departureDateTime == null) ? 0 : departureDateTime.hashCode());
		result = prime * result + ((destinationAirport == null) ? 0 : destinationAirport.hashCode());
		result = prime * result + ((scheduleId == null) ? 0 : scheduleId.hashCode());
		result = prime * result + ((sourceAirport == null) ? 0 : sourceAirport.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (arrivalDateTime == null) {
			if (other.arrivalDateTime != null)
				return false;
		} else if (!arrivalDateTime.equals(other.arrivalDateTime))
			return false;
		if (departureDateTime == null) {
			if (other.departureDateTime != null)
				return false;
		} else if (!departureDateTime.equals(other.departureDateTime))
			return false;
		if (destinationAirport == null) {
			if (other.destinationAirport != null)
				return false;
		} else if (!destinationAirport.equals(other.destinationAirport))
			return false;
		if (scheduleId == null) {
			if (other.scheduleId != null)
				return false;
		} else if (!scheduleId.equals(other.scheduleId))
			return false;
		if (sourceAirport == null) {
			if (other.sourceAirport != null)
				return false;
		} else if (!sourceAirport.equals(other.sourceAirport))
			return false;
		return true;
	}
	
	
	
}
