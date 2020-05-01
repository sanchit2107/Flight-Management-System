package com.org.exceptions;

public class ScheduleNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ScheduleNotFoundException(String str) {
		super(str);
	}
}
