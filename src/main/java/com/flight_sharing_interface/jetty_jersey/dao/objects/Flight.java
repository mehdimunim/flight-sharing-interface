package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Flight {

	@PrimaryKey
	private int aircraftId;
	private int pilotId;

	@PrimaryKey
	private Date departureDate;
	@PrimaryKey
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

	public Flight(int aircraftId, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate,
			LocalTime arrivalTime, String departureAerodrome, String arrivalAerodrome, double price,
			String meetingPlace, int pilotId) {

		this.aircraftId = aircraftId;

		this.departureDate = Date.valueOf(departureDate);
		this.departureTime = Time.valueOf(departureTime);

		this.arrivalDate = Date.valueOf(arrivalDate);
		this.arrivalTime = Time.valueOf(arrivalTime);

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

	public LocalDate getDepartureDate() {
		return departureDate.toLocalDate();
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = Date.valueOf(departureDate);
	}

	public LocalTime getDepartureTime() {
		return departureTime.toLocalTime();
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = Time.valueOf(departureTime);
	}

	public LocalDate getArrivalDate() {
		return arrivalDate.toLocalDate();
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = Date.valueOf(arrivalDate);
	}

	public LocalTime getArrivalTime() {
		return arrivalTime.toLocalTime();
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = Time.valueOf(arrivalTime);
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
