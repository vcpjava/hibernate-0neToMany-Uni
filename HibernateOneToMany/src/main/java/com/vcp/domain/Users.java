package com.vcp.domain;

import java.util.Set;

public class Users {

	private int userId;
	private String firstName;
	private String lastName;
	private String email;

	private Set<PhoneNumbers> phoneNumbers;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<PhoneNumbers> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumbers> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
