package com.bookmyshow.exception;

public class ScreenNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ScreenNotFoundException() {

	}
	
	public ScreenNotFoundException(String message) {
		
		super(message);
	}
}
