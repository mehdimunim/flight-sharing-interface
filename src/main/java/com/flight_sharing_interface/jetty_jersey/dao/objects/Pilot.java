package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

//extends passenger??
// rajouter int numFlightHours
// String flightInformation
// List<Flight> flightList;
@PersistenceCapable
public class Pilot {
	@PrimaryKey
	public long id;
	
	public String name;
	public String surname;
	public String qualifications;
	public String experience;
	public int numberflightHour;
	public String flightInformation;
	public List<Flight> flightList;

	public Pilot() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param surname
	 * @param qualifications
	 * @param experience
	 * @param numberflightHour
	 * @param flightInformation
	 * @param flightList
	 */
	public Pilot(String name, String surname, String qualifications, String experience, int numberflightHour,
			String flightInformation, List<Flight> flightList) {
		this.name = name;
		this.surname = surname;
		this.qualifications = qualifications;
		this.experience = experience;
		this.numberflightHour = numberflightHour;
		this.flightInformation = flightInformation;
		this.flightList = flightList;
	}

	/**
	 * @param name
	 * @param surname
	 * @param flightInformation
	 */
	public Pilot(String name, String surname, String flightInformation) {
		this.name = name;
		this.surname = surname;
		this.flightInformation = flightInformation;
	}

	public Pilot(String name, String surname, String qualifications, String experience, int id) {
		this.name = name;
		this.surname = surname;		
		this.qualifications = qualifications;
		this.experience = experience;
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getFlightInformation() {
		return flightInformation;
	}

	public void setFlightInformation(String flightInformation) {
		this.flightInformation = flightInformation;
	}

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}
	
}