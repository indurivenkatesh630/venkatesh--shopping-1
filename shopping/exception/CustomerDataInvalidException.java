package com.shopping.exception;

public class CustomerDataInvalidException extends RuntimeException {
    private String invalid;

	public CustomerDataInvalidException() {
		super();
	}

	public CustomerDataInvalidException(String invalid) {
		super();
		this.invalid = invalid;
	}

	public String getInvalid() {
		return invalid;
	}

	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}

	@Override
	public String toString() {
		return "CustomerDataInvalidException [Exception=" + invalid + "]";
	}
    
}
