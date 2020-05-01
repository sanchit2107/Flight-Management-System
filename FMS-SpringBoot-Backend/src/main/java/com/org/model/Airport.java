package com.org.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport
/**
 * Class Airport
 */
{
	@Id
	private String airportCode;
	private String airportLocation;
	private String airportName;

	public Airport(String airportName, String airportLocation, String airportCode)
	/**
	 * parameterized Constructor
	 */
	{
		this.airportName = airportName;
		this.airportLocation = airportLocation;
		this.airportCode = airportCode;
	}

	public Airport()
	/**
	 * Unparameterized Constructor
	 */
	{
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	@Override
	public String toString() {
		return "Airport{" + "airportName='" + airportName + '\'' + ", airportLocation='" + airportLocation + '\''
				+ ", airportCode='" + airportCode + '\'' + '}';
	}
}
