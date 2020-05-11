
package com.org.exceptions;

/**
 * @author: SANCHIT SINGHAL
 * description:  
 * created date:
 * modified: 
 */
public class InvalidAirportException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidAirportException() {
	}
	
	public InvalidAirportException(String message){
		super(message);
	}

}
