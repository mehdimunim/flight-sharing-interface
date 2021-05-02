package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.sql.Date;
import java.sql.Time;
import java.time.DateTimeException;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 
 * A flight is defined by an aircraft (aircraft id) leaving at given departure
 * date and time
 * 
 * A flight is done by one and only one pilot
 * 
 *
 */
@PersistenceCapable
public class Flight {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private long flightId;

	private long aircraftId;
	private long pilotId;

	private Date departureDate;
	private Time departureTime;

	private Date arrivalDate;
	private Time arrivalTime;

	private String departureAerodrome;
	private String arrivalAerodrome;

	private double price;
	private String meetingPlace;

	public Flight(int aircraftId, Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime,
			String departureAerodrome, String arrivalAerodrome, double price, String meetingPlace, int pilotId)
			throws Exception {

		this.aircraftId = aircraftId;

		this.departureDate = departureDate;
		this.departureTime = departureTime;

		if (departureDate.before(departureDate)
				|| (departureDate.equals(arrivalDate) && departureTime.before(arrivalTime))) {
			this.arrivalDate = arrivalDate;
			this.departureDate = departureDate;
		}

		else {
			throw new DateTimeException("Arrival before departure");
		}

		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;

		this.departureAerodrome = departureAerodrome;
		this.arrivalAerodrome = arrivalAerodrome;
		this.price = price;
		this.meetingPlace = meetingPlace;

		this.pilotId = pilotId;
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public long getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(long aircraftId) {
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

	public void setDepartureAerodrome(String departureAerodrome) {
		this.departureAerodrome = departureAerodrome;
	}

	public String getArrivalAerodrome() {
		return arrivalAerodrome;
	}

	public void setArrivalAerodrome(String arrivalAerodrome) {
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

	public long getPilotId() {
		return pilotId;
	}

	public void setPilotId(long pilotId) {
		this.pilotId = pilotId;
	}

}
