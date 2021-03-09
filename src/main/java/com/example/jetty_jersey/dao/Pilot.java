package com.example.jetty_jersey.dao;

import java.util.List;

//extends passenger??
// rajouter int numFlightHours
// String flightInformation
// List<Flight> flightList;
public class Pilot {
	public int id;
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
	
}