package com.fiveg.assignment.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fiveg.assignment.exceptions.InvalidCLArgumentException;
import com.fiveg.assignment.model.Stock;

public interface FileOperations {
	// This method returns the file object back to the caller.
	public File checkCLArgument(final String fileArgument) throws InvalidCLArgumentException;
	
	// This method returns received file properties like exists, isFile, its contents,
	// is Readable etc. and return that File object back to the caller.
	public boolean checkFile(final File stockFile);
	
	// this method reads the data from file and stores the stock objects in a list and returns 
	// that list to the caller.
    public List<Stock> processFile(final File stockFile) throws IOException, NullPointerException;
}
