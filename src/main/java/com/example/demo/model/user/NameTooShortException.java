package com.example.demo.model.user;


public class NameTooShortException extends IllegalArgumentException {

	public NameTooShortException(){
		super();
	}

	public NameTooShortException(String message){
		super(message);
	}
}
