package com.fiveg.assignment.exceptions;

public class FileCantReadException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String expMsg;
	
    public FileCantReadException() {}
    public FileCantReadException(String expMsg) {
    	super(expMsg);
    	this.expMsg = expMsg;
    }
    public String getExceptionMsg() {
    	return "Exception Occured due to : "+expMsg;
    }
}
