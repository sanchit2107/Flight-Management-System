package com.org.exceptions;

/**
 * @author: SANCHIT SINGHAL
 * description:  
 * created date:
 * modified: 
 */
public class InvalidBookingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidBookingException(){
	}
	
	public InvalidBookingException(String message){
		super(message);
	}

}
