package com.example.demo.model.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Email {

	@Column(name = "email")
	private String email;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


	public Email(String email) throws InvalidEmailException {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if (!matcher.find()) {
			throw new InvalidEmailException(String.format("%s is not a valid e-mail address.", email));
		}
		this.email = email;
	}

	protected Email(){}


	public boolean equals(Email email) {
		return this.email.equals(email.getEmail());
	}

	public String getEmail() {
		return this.email;
	}

	public String toString() {
		return this.email;
	}
}
