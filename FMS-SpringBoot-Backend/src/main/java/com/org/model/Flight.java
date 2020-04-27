package com.org.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Flight {

	@Id
	private int flightNo;
	private String carrierName;
	private String flightModel;
	private int seatCapacity;
	
	@OneToOne(mappedBy = "flight")
	private ScheduledFlight scheduleFlightObj;
	
	public Flight() {}
	
	/**
	 * @param flightNo
	 * @param carrierName
	 * @param flightModel
	 * @param seatCapacity
	 */
	public Flight(int flightNo, String carrierName, String flightModel, int seatCapacity) {
		super();
		this.flightNo = flightNo;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}
	
	/**
	 * @return the flightNo
	 */
	public int getFlightNo() {
		return flightNo;
	}
	/**
	 * @param flightNo the flightNo to set
	 */
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	/**
	 * @return the carrierName
	 */
	public String getCarrierName() {
		return carrierName;
	}
	/**
	 * @param carrierName the carrierName to set
	 */
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	/**
	 * @return the flightModel
	 */
	public String getFlightModel() {
		return flightModel;
	}
	/**
	 * @param flightModel the flightModel to set
	 */
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	/**
	 * @return the seatCapacity
	 */
	public int getSeatCapacity() {
		return seatCapacity;
	}
	/**
	 * @param seatCapacity the seatCapacity to set
	 */
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
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
