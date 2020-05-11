package com.org.exceptions;

public class FmsException extends Exception{
		
	private static final long serialVersionUID = 3557343985224509108L;

	public FmsException() {
	}
	
	public FmsException(String message){
		super(message);
	}

}