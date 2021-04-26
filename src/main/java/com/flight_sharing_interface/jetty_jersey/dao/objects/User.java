package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.sql.Date;

/**
 * 
 * 
 * Abstract class from which Pilot and Passenger are derived
 * 
 */
public abstract class User {

	String firstName;
	String lastName;
	String civilStatut;
	Date birthday;
	String email;

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

	public String getCivilStatut() {
		return civilStatut;
	}

	public void setCivilStatut(String civilStatut) {
		this.civilStatut = civilStatut;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
