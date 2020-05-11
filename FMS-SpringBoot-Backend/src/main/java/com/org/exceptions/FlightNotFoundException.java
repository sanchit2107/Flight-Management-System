package com.org.exceptions;

/**
 * @author: SANCHIT SINGHAL
 * description:  
 * created date:
 * modified: 
 */
public class FlightNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FlightNotFoundException(){
		
	}
	
	public FlightNotFoundException(String message){
		super(message);
	}

}
