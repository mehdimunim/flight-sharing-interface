/**
 * 
 */
package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Represents a flight (aircraft id, departure date and time) booked by a
 * passenger (passenger id)
 * 
 * @author Mehdi
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@PersistenceCapable
public class Booking {

	public Booking(long passengerId, long aircraftId, Timestamp timestamp, LocalDate departureDate,
			LocalTime departureTime) {
		this.passengerId = passengerId;
		this.aircraftId = aircraftId;
		this.timestamp = timestamp;

		this.departureDate = Date.valueOf(departureDate);
		this.departureTime = Time.valueOf(departureTime);
	}

	long passengerId;
	long aircraftId;

	@PrimaryKey
	Timestamp timestamp;
	Date departureDate;
	Time departureTime;

	public long getPilotId() {
		return passengerId;
	}

	public void setPilotId(long passengerId) {
		this.passengerId = passengerId;
	}

	public long getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(long aircraftId) {
		this.aircraftId = aircraftId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
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

}
