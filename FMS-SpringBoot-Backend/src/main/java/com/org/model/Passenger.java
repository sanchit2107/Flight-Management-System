package com.org.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author: SANCHIT SINGHAL
 * description: Passenger Model
 */
@Entity(name = "Passenger")
@EntityListeners({ AuditingEntityListener.class })
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pnr_number")
	private BigInteger pnrNumber;
	@Column(name = "passenger_name")
	@Pattern(regexp = "^[\\p{L} .'-]+$", message = "Name should not contain special characters.")
	@Size(min = 0, max = 30, message = "Name should be less than 30 characters.")
	private String passengerName;
	@Column(name = "passenger_age")
	@Positive(message = "Age cannot be less than 0.")
	private Integer passengerAge;
	@Column(name = "passenger_UIN")
	private BigInteger passengerUIN;
	@Column(name = "passengerState")
	private Boolean passengerState;
	@Column(name = "created_date", nullable = false, updatable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "created_by")
	@CreatedBy
	private String createdBy;
	@Column(name = "modified_by")
	@LastModifiedBy
	private String modifiedBy;

	public Passenger() {
		super();
	}

	public Passenger(BigInteger pnrNumber, String passengerName, Integer passengerAge, BigInteger passengerUIN,
			Boolean passengerState) {
		super();
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.passengerState = passengerState;
	}

	@Override
	public String toString() {
		return "Passenger [pnrNumber=" + pnrNumber + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerUIN=" + passengerUIN + ", passengerState=" + passengerState + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((passengerAge == null) ? 0 : passengerAge.hashCode());
		result = prime * result + ((passengerName == null) ? 0 : passengerName.hashCode());
		result = prime * result + ((passengerState == null) ? 0 : passengerState.hashCode());
		result = prime * result + ((passengerUIN == null) ? 0 : passengerUIN.hashCode());
		result = prime * result + ((pnrNumber == null) ? 0 : pnrNumber.hashCode());
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
		Passenger other = (Passenger) obj;
		if (passengerAge == null) {
			if (other.passengerAge != null)
				return false;
		} else if (!passengerAge.equals(other.passengerAge))
			return false;
		if (passengerName == null) {
			if (other.passengerName != null)
				return false;
		} else if (!passengerName.equals(other.passengerName))
			return false;
		if (passengerState == null) {
			if (other.passengerState != null)
				return false;
		} else if (!passengerState.equals(other.passengerState))
			return false;
		if (passengerUIN == null) {
			if (other.passengerUIN != null)
				return false;
		} else if (!passengerUIN.equals(other.passengerUIN))
			return false;
		if (pnrNumber == null) {
			if (other.pnrNumber != null)
				return false;
		} else if (!pnrNumber.equals(other.pnrNumber))
			return false;
		return true;
	}

	public BigInteger getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public Boolean getPassengerState() {
		return passengerState;
	}

	public void setPassengerState(Boolean passengerState) {
		this.passengerState = passengerState;
	}

	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}

}