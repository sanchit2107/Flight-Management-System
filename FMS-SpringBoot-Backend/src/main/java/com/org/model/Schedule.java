package com.org.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "schedule")
public class Schedule {
	@Id
	@Column(name = "schedule_Id")
	private BigInteger scheduleId;

	@OneToOne(fetch = FetchType.EAGER)
	private Airport srcAirport;

	@OneToOne(fetch = FetchType.EAGER)
	private Airport dstnAirport;

	@Column(name = "departure_date")
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private String deptDateTime;

	@Column(name = "arrival_date")
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private String arrDateTime;

	/*
	 * Default constructor
	 */
	public Schedule() {

	}

	/*
	 * Parameterized constructor
	 */
	public Schedule(BigInteger scheduleId, Airport sourceAirport, Airport destinationAirport,
			String departureDateTime, String arrivalDateTime) {
		super();
		this.scheduleId = scheduleId;
		this.srcAirport = sourceAirport;
		this.dstnAirport = destinationAirport;
		this.deptDateTime = departureDateTime;
		this.arrDateTime = arrivalDateTime;
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
		return srcAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.srcAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return dstnAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.dstnAirport = destinationAirport;
	}

	public String getDepartureDateTime() {
		return deptDateTime;
	}

	public void setDepartureDateTime(String departureDateTime) {
		this.deptDateTime = departureDateTime;
	}

	public String getArrivalDateTime() {
		return arrDateTime;
	}

	public void setArrivalDateTime(String arrivalDateTime) {
		this.arrDateTime = arrivalDateTime;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", sourceAirport=" + srcAirport + ", destinationAirport="
				+ dstnAirport + ", departureDateTime=" + deptDateTime + ", arrivalDateTime="
				+ arrDateTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrDateTime == null) ? 0 : arrDateTime.hashCode());
		result = prime * result + ((deptDateTime == null) ? 0 : deptDateTime.hashCode());
		result = prime * result + ((dstnAirport == null) ? 0 : dstnAirport.hashCode());
		result = prime * result + ((scheduleId == null) ? 0 : scheduleId.hashCode());
		result = prime * result + ((srcAirport == null) ? 0 : srcAirport.hashCode());
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
		if (arrDateTime == null) {
			if (other.arrDateTime != null)
				return false;
		} else if (!arrDateTime.equals(other.arrDateTime))
			return false;
		if (deptDateTime == null) {
			if (other.deptDateTime != null)
				return false;
		} else if (!deptDateTime.equals(other.deptDateTime))
			return false;
		if (dstnAirport == null) {
			if (other.dstnAirport != null)
				return false;
		} else if (!dstnAirport.equals(other.dstnAirport))
			return false;
		if (scheduleId == null) {
			if (other.scheduleId != null)
				return false;
		} else if (!scheduleId.equals(other.scheduleId))
			return false;
		if (srcAirport == null) {
			if (other.srcAirport != null)
				return false;
		} else if (!srcAirport.equals(other.srcAirport))
			return false;
		return true;
	}

}
