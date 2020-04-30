package com.org.exceptions;

public class ScheduledFlightAlreadyPresentException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ScheduledFlightAlreadyPresentException(String str) {
		super(str);
	}

}
