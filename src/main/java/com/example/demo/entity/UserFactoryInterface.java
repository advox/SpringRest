package com.example.demo.entity;

public interface UserFactoryInterface {
	abstract User make(String name, String email, String password);
}
