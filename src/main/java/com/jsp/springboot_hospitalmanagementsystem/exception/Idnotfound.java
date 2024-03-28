package com.jsp.springboot_hospitalmanagementsystem.exception;

public class Idnotfound extends RuntimeException {

	private String message="Id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public Idnotfound(String message) {
		this.message = message;
	}

	public Idnotfound() {
		super();
	}

}
 