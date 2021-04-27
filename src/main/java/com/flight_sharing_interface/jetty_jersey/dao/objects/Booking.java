/**
 * 
 */
package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.sql.Timestamp;

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

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private long bookingId;

	long flightId;
	long passengerId;
	Timestamp timestamp;

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

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
