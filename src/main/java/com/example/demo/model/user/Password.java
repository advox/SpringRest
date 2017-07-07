package com.example.demo.model.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Password {

	@Column(name="PASSWORD")
	private String passphrase;

	public Password(String passphrase) {
		ArrayList<String> validationErrors = new ArrayList<>();

		if (passphrase.length() < 10) {
			validationErrors.add("Password should be at least 10 characters long.");
		}

		Pattern upperCaseAtLeastOnce = Pattern.compile("(?=.*[A-Z])");
		Matcher matcher = upperCaseAtLeastOnce.matcher(passphrase);
		if (!matcher.find()) {
			validationErrors.add("An upper case letter must occur at least once.");
		}

		Pattern lowerCaseAtLeastOnce = Pattern.compile("(?=.*[a-z])");
		matcher = lowerCaseAtLeastOnce.matcher(passphrase);
		if (!matcher.find()) {
			validationErrors.add("An lower case letter must occur at least once.");
		}

		if (!validationErrors.isEmpty()) {
			throw new PasswordTooSimpleException(String.join(" ", validationErrors));
		}

		this.passphrase = passphrase;
	}

	protected Password(){}


	public boolean equals(Password email) {
		return email.toString().equals(this.toString());
	}

	public String getPassphrase() {
		return this.passphrase;
	}


	public String toString() {
		return this.passphrase;
	}
}
