package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Flight {
	public int id;
	public double price;
	public String meeting_place;
	public String departure_aerodrome;
	public String destination_aerodrome;
	public int availabePlaces;
	public Pilot pilot;
	public List<Passenger> passengers = new ArrayList<Passenger>();
	@Persistent
	public LocalDateTime departureDateTime;
	@Persistent
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
	 * @param departureDateTime
	 * @param arrivalDateTime
	 */
	public Flight(int id, double price, String meeting_place, String departure_aerodrome, String destination_aerodrome,
			int availabePlaces, Pilot pilot, List<Passenger> passengers, LocalDateTime departureDateTime,
			LocalDateTime arrivalDateTime) {
		this.price = price;
		this.meeting_place = meeting_place;
		this.departure_aerodrome = departure_aerodrome;
		this.destination_aerodrome = destination_aerodrome;
		this.id = id;
		this.availabePlaces = availabePlaces;
		this.pilot = pilot;
		this.passengers = passengers;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
	}

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMeeting_place() {
		return meeting_place;
	}

	public void setMeeting_place(String meeting_place) {
		this.meeting_place = meeting_place;
	}

	public String getDeparture_aerodrome() {
		return departure_aerodrome;
	}

	public void setDeparture_aerodrome(String departure_aerodrome) {
		this.departure_aerodrome = departure_aerodrome;
	}

	public String getDestination_aerodrome() {
		return destination_aerodrome;
	}

	public void setDestination_aerodrome(String destination_aerodrome) {
		this.destination_aerodrome = destination_aerodrome;
	}

	public int getAvailabePlaces() {
		return availabePlaces;
	}

	public void setAvailabePlaces(int availabePlaces) {
		this.availabePlaces = availabePlaces;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

}
