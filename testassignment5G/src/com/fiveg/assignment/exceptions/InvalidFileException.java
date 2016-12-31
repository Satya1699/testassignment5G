package com.fiveg.assignment.exceptions;

public class InvalidFileException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String expMsg;
	
    public InvalidFileException() {}
    public InvalidFileException(String expMsg) {
    	super(expMsg);
    	this.expMsg = expMsg;
    }
    public String getExceptionMsg() {
    	return "Exception Occured due to : "+expMsg;
    }
}
