package com.seoyeon.rental.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class UserAuthException extends Exception implements Serializable{

	@SuppressWarnings("unused")
	private HttpStatus httpStatus;
	@SuppressWarnings("unused")
	private String msg;

	public UserAuthException(String msg) {
		super(msg);
	}
	
	public UserAuthException(String msg, HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		this.msg = msg;
	}
}
