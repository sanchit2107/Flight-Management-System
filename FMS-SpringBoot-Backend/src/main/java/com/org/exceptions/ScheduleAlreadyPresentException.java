package com.org.exceptions;

public class ScheduleAlreadyPresentException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ScheduleAlreadyPresentException(String str) {
		super(str);
	}
}
