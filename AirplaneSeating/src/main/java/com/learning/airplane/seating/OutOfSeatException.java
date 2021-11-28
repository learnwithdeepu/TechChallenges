package com.learning.airplane.seating;

public class OutOfSeatException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OutOfSeatException(String message) {
		super(message);
	}

}
