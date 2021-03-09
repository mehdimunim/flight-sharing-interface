package com.example.jetty_jersey.dao;

	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.List;


	//rajouter : int id; first name et last name?? ; LocalDate birthday
	// List<Flight> bookedFlights

	//ATTENTION ICI il ne faut pas rendre public des informations qui ne devraient 
	// pas sortir comme le mdp par exemple 

	public class Passenger {
		
		public String first_name;
		public String last_name;
		public String civil_statut;
		public String mail_adresse;
		public int number;
		public LocalDate birthday;
		public List<Flight> bookedFlights = new ArrayList<>();
		public int id;
		
		
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
		public Passenger(String first_name, String last_name, String civil_statut, String mail_adresse, int number,
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
		
		
		public Passenger(String name, String surname, String civil_statut, String mail_adresse, int number) {
			this.first_name = name;
			this.last_name = surname;
			this.civil_statut = civil_statut;
			this.mail_adresse = mail_adresse;
			this.number = number;
		}
		
}
