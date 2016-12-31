package com.fiveg.assignment.exceptions;

public class InvalidCLArgumentException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String expMsg;
	
    public InvalidCLArgumentException() {}
    public InvalidCLArgumentException(String expMsg) {
    	super(expMsg);
    	this.expMsg = expMsg;
    }
    public String getExceptionMsg() {
    	return "Exception Occured due to : "+expMsg;
    }
}
