package com.fiveg.assignment.exceptions;

public class FileEmptyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String expMsg;
	
    public FileEmptyException() {}
    public FileEmptyException(String expMsg) {
    	super(expMsg);
    	this.expMsg = expMsg;
    }
    public String getExceptionMsg() {
    	return "Exception Occured due to : "+expMsg;
    }
}
