package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.sql.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@PersistenceCapable
public class Passenger extends User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private long passengerId;

	public Passenger(String firstName, String lastName, String civilStatut, Date birthday, String email,
			int passengeId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.civilStatut = civilStatut;
		this.birthday = birthday;
		this.email = email;
		this.passengerId = passengeId;
	}

	public long getPassengeId() {
		return passengerId;
	}

	public void setPassengeId(long passengerId) {
		this.passengerId = passengerId;
	}

}