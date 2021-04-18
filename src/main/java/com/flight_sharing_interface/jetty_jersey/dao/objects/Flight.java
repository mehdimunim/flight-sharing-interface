package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Flight {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	protected int id;

	@Persistent(defaultFetchGroup = "true")
	protected List<Flight> flights = null;

	public double price;
	public String meeting_place;
	public String departure_aerodrome;
	public String destination_aerodrome;
	public int availabePlaces;
	public Pilot pilot;
	public List<Passenger> passengers = new ArrayList<Passenger>();
	@Persistent
	public LocalDate departureDate;
	@Persistent
	public LocalDate arrivalDate;

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
			int availabePlaces, Pilot pilot, List<Passenger> passengers, LocalDate departureDate,
			LocalDate arrivalDate) {
		this.id = id;
		this.price = price;
		this.meeting_place = meeting_place;
		this.departure_aerodrome = departure_aerodrome;
		this.destination_aerodrome = destination_aerodrome;
		this.availabePlaces = availabePlaces;
		this.pilot = pilot;
		this.passengers = passengers;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
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

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Flight() {
		super();
		this.flights = new ArrayList<Flight>();
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

}
