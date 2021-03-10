package com.example.jetty_jersey.ws;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//passer tous les attributs en public 
//(pour que JackSon qui s'occupse de la conversion java vers json ne saura pas le faire)

public class Flight {

	public double price;
	public String meeting_place;
	public String departure_aerodrome;
	public String destination_aerodrome;
	public int id;
	public int availabePlaces;
	public Pilot pilot;
	public List<Passenger> passengers = new ArrayList<Passenger>();
	public LocalDateTime departureTime;
	public LocalDate departureDate;
	public LocalDate arrivalDate;
	public LocalDateTime arrivalTime;
	public LocalDateTime duration; //Duration
	public LocalDateTime departureDateTime;
	public LocalDateTime arrivalDateTime;

	/**
	 * @param price
	 * @param meeting_place
	 * @param departure_aerodrome
	 * @param destination_aerodrome
	 * @param id
	 * @param availabePlaces
	 * @param pilot
	 * @param passengers
	 * @param departureTime
	 * @param departureDate
	 * @param arrivalDate
	 * @param arrivalTime
	 * @param duration
	 */
	public Flight(double price, String meeting_place, String departure_aerodrome, String destination_aerodrome, int id,
			int availabePlaces, Pilot pilot, List<Passenger> passengers, LocalDateTime departureTime,
			LocalDate departureDate, LocalDate arrivalDate, LocalDateTime arrivalTime, LocalDateTime duration) {
		this.price = price;
		this.meeting_place = meeting_place;
		this.departure_aerodrome = departure_aerodrome;
		this.destination_aerodrome = destination_aerodrome;
		this.id = id;
		this.availabePlaces = availabePlaces;
		this.pilot = pilot;
		this.passengers = passengers;
		this.departureTime = departureTime;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
	}


	public Flight() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Flight(LocalDateTime duration, int availabePlaces, double price, String meeting_place, String departure_aerodrome,
			String destination_aerodrome, LocalDateTime departureTime, LocalDate arrivalDate, LocalDateTime arrivalTime, int id, Pilot pilot, List<Passenger> passengers, LocalDate departureDate) {
		this.duration = duration;
		this.availabePlaces = availabePlaces;
		this.price = price;
		this.meeting_place = meeting_place;
		this.departure_aerodrome = departure_aerodrome;
		this.destination_aerodrome = destination_aerodrome;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;	
		this.id = id;
		this.pilot = pilot;
		this.passengers = passengers;
		this.departureDate = departureDate;
		
		
		
	}



}


