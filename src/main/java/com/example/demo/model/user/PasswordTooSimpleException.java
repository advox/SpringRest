package com.example.demo.model.user;


public class PasswordTooSimpleException extends IllegalArgumentException{

	public PasswordTooSimpleException(){
		super();
	}

	public PasswordTooSimpleException(String message){
		super(message);
	}
}
