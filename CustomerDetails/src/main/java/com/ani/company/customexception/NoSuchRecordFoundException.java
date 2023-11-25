package com.ani.company.customexception;

public class NoSuchRecordFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchRecordFoundException(String messgae) {
		super(messgae);
	}

}
