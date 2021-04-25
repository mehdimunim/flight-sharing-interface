package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

//rajouter : int id; first name et last name?? ; LocalDate birthday
// List<Flight> bookedFlights

//ATTENTION ICI il ne faut pas rendre public des informations qui ne devraient 
// pas sortir comme le mdp par exemple 

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@PersistenceCapable
public class Passenger {
	// define primary key id automatically
	@PrimaryKey
	public int id;

	public String first_name;
	public String last_name;
	public String civil_statut;
	public String mail_adresse;
	public Long number;
	public LocalDate birthday;
	public List<Flight> bookedFlights = new ArrayList<Flight>();

	/**
	 * @param first_name
	 * @param last_name
	 * @param civil_statut
	 * @param mail_adresse
	 * @param number
	 * @param birthday
	 * @param bookedFlights
	 * @param id
	 */
	public Passenger(String first_name, String last_name, String civil_statut, String mail_adresse, Long number,
			LocalDate birthday, List<Flight> bookedFlights, int id) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.civil_statut = civil_statut;
		this.mail_adresse = mail_adresse;
		this.number = number;
		this.birthday = birthday;
		this.bookedFlights = bookedFlights;
		this.id = id;
	}

	/**
	 * @param first_name
	 * @param last_name
	 * @param civil_statut
	 */
	public Passenger(String first_name, String last_name, String civil_statut) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.civil_statut = civil_statut;
	}

	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCivil_statut() {
		return civil_statut;
	}

	public void setCivil_statut(String civil_statut) {
		this.civil_statut = civil_statut;
	}

	public String getMail_adresse() {
		return mail_adresse;
	}

	public void setMail_adresse(String mail_adresse) {
		this.mail_adresse = mail_adresse;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public List<Flight> getBookedFlights() {
		return bookedFlights;
	}

	public void setBookedFlights(List<Flight> bookedFlights) {
		this.bookedFlights = bookedFlights;
	}

}