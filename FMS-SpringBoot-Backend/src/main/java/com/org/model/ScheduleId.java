package com.org.model;

import java.io.Serializable;

import javax.persistence.Embeddable;


/*
  Class for composite key
 */

@Embeddable
public class ScheduleId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sourceAirport;
	private String destinationAirport;
	
	/*
	 Default constructor
	 */
	public ScheduleId() {
		
	}
	
	
	/*
	 Parameterized constructor
	 */
	public ScheduleId(String sourceAirport, String destinationAirport) {
		super();
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "ScheduleId [sourceAirport=" + sourceAirport + ", destinationAirport=" + destinationAirport + "]";
	}
	

}
