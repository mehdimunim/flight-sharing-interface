/**
 * 
 */
package com.example.jetty_jersey.ws;

import java.time.LocalDateTime;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author DANSO
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking {
	
	

	/**
	 * @param id
	 * @param date_time
	 * @param passenger
	 */
	public Booking(int id,LocalDateTime date_time, Passenger passenger) {
		this.id = id;
		this.date_time = date_time;
		this.passenger = passenger;
	}
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	public int id;
	public LocalDateTime date_time;
	public Passenger passenger;

	 
}





