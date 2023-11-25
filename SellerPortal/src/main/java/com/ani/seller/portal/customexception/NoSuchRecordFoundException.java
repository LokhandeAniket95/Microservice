package com.ani.seller.portal.customexception;

public class NoSuchRecordFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchRecordFoundException(String messgae) {
		super(messgae);
	}

}
