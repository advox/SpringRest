package com.example.demo.entity;


import com.example.demo.model.user.Email;
import com.example.demo.model.user.Name;
import com.example.demo.model.user.Password;
import org.springframework.stereotype.Service;

@Service
public class UserFactory implements UserFactoryInterface {

	public User make(String name, String email, String password) {
		return new User(
				new Name(name),
				new Email(email),
				new Password(password)
		);
	}
}
