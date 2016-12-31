package com.fiveg.assignment.exceptions;

public class FileDoesntExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String expMsg;
	
    public FileDoesntExistException() {}
    public FileDoesntExistException(String expMsg) {
    	super(expMsg);
    	this.expMsg = expMsg;
    }
    public String getExceptionMsg() {
    	return "Exception Occured due to : "+expMsg;
    }
}
