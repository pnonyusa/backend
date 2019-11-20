package com.mypicknpay.webApi.jwt.response;



public class FileStoreException extends RuntimeException  {
        
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileStoreException(String message) {
		 
		super(message);
		
	}

	public FileStoreException(String message, Throwable cause) {
		
		super(message,cause);
		// TODO Auto-generated constructor stub
	}
}
