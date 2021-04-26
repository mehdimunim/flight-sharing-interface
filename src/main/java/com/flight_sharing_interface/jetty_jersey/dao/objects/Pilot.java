package com.flight_sharing_interface.jetty_jersey.dao.objects;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Pilot extends User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private long pilotId;

	private String qualifications;
	private String experience;
	private int numberflightHour;

	public Pilot(String firstName, String lastName, String civilStatut, String birthday, String email, long pilotId,
			String qualifications, String experience, int numberflightHour) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.civilStatut = civilStatut;
		this.birthday = birthday;
		this.email = email;
		this.pilotId = pilotId;
		this.qualifications = qualifications;
		this.experience = experience;
		this.numberflightHour = numberflightHour;
	}

	public long getPilotId() {
		return pilotId;
	}

	public void setPilotId(long pilotId) {
		this.pilotId = pilotId;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getNumberflightHour() {
		return numberflightHour;
	}

	public void setNumberflightHour(int numberflightHour) {
		this.numberflightHour = numberflightHour;
	}

}