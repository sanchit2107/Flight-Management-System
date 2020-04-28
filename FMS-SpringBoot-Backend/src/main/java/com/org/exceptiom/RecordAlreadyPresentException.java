package com.org.exceptiom;

public class RecordAlreadyPresentException extends RuntimeException {
	
	public RecordAlreadyPresentException(String s) {
		super(s);
	}
}
