/**
 * 
 */
package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.time.LocalDateTime;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author DANSO
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@PersistenceCapable
public class Booking {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	public long id;

	public LocalDateTime date_time;
	public Passenger passenger;

	/**
	 * @param id
	 * @param date_time
	 * @param passenger
	 */
	public Booking(int id, LocalDateTime date_time, Passenger passenger) {
		this.id = id;
		this.date_time = date_time;
		this.passenger = passenger;
	}

	public Booking() {
		// TODO Auto-generated constructor stub
	}

}
