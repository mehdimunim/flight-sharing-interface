package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 
 * A flight is defined by an aircraft (aircraft id) leaving at given departure
 * date and time
 * 
 * We assumed that a flight was done by one and only one pilot
 * 
 * @author Mehdi
 *
 */
@PersistenceCapable
public class Flight {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private long flightId;

	private int aircraftId;
	private int pilotId;

	private Date departureDate;
	private Time departureTime;

	private Date arrivalDate;
	private Time arrivalTime;

	private String departureAerodrome;
	private String arrivalAerodrome;

	private double price;
	private String meetingPlace;

	// Defining children seems to be useful for postman
	@Persistent(defaultFetchGroup = "true")
	protected List<Flight> flights = null;

	public Flight(int aircraftId, Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime,
			String departureAerodrome, String arrivalAerodrome, double price, String meetingPlace, int pilotId) {

		this.aircraftId = aircraftId;

		this.departureDate = departureDate;
		this.departureTime = departureTime;

		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;

		this.departureAerodrome = departureAerodrome;
		this.arrivalAerodrome = arrivalAerodrome;
		this.price = price;
		this.meetingPlace = meetingPlace;

		this.pilotId = pilotId;
	}

	public int getId() {
		return aircraftId;
	}

	public void setId(int aircraftId) {
		this.aircraftId = aircraftId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMeetingPlace() {
		return meetingPlace;
	}

	public void setMeetingPlace(String meetingPlace) {
		this.meetingPlace = meetingPlace;
	}

	public String getDepartureAerodrome() {
		return departureAerodrome;
	}

	public void setDeparture_aerodrome(String departureAerodrome) {
		this.departureAerodrome = departureAerodrome;
	}

	public String getDestination_aerodrome() {
		return arrivalAerodrome;
	}

	public void setDestination_aerodrome(String arrivalAerodrome) {
		this.arrivalAerodrome = arrivalAerodrome;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
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

	public int getPilotId() {
		return pilotId;
	}

	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
	}

}
