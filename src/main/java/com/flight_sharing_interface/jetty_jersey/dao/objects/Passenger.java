package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.sql.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@PersistenceCapable
public class Passenger {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private long passengerId;

	String firstName;
	String lastName;
	String civilStatut;
	Date birthday;
	String email;

	public Passenger(String firstName, String lastName, String civilStatut, Date birthday, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.civilStatut = civilStatut;
		this.birthday = birthday;
		this.email = email;
	}

	public Passenger() {
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
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