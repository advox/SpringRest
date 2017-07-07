package com.example.demo.model.user;


public class InvalidEmailException extends IllegalArgumentException {

	public InvalidEmailException(){
		super();
	}

	public InvalidEmailException(String message){
		super(message);
	}
}
