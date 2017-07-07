package com.example.demo.model.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {

	@Column(name = "USERNAME")
	private String name;

	public Name(String name) throws NameTooShortException {
		if (name.length() < 5) {
			throw new NameTooShortException("Name should be at least 5 characters long.");
		}
		this.name = name;
	}

	protected Name(){}

	public String getName() {
		return this.name;
	}

	public boolean equals(Name name) {
		return this.name.equals(name.getName());
	}

	public String toString() {
		return this.name;
	}
}
