/**
 * 
 */
package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
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

	public Booking(long passengerId, long flightId, Timestamp timestamp) {
		this.passengerId = passengerId;
		this.flightId = flightId;
		this.timestamp = timestamp;
	}

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private long bookingId;

	long flightId;
	long passengerId;
	// timestamp is the initialized at now
	Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
}
