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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@PersistenceCapable
public class Booking {

	public Booking(long pilotId, long aircraftId, Timestamp timestamp, LocalDate departureDate,
			LocalTime departureTime) {
		this.pilotId = pilotId;
		this.aircraftId = aircraftId;
		this.timestamp = timestamp;

		this.departureDate = Date.valueOf(departureDate);
		this.departureTime = Time.valueOf(departureTime);
	}

	long pilotId;
	long aircraftId;
	Timestamp timestamp;
	Date departureDate;
	Time departureTime;

	public long getPilotId() {
		return pilotId;
	}

	public void setPilotId(long pilotId) {
		this.pilotId = pilotId;
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
