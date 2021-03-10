package com.example.jetty_jersey.dao;

import java.util.List;

import com.example.jetty_jersey.ws.Flight;

public interface DAO {


/**
 * @return the list of booked flights
 */

List<Flight>  getBookedFlights();

/**
 *@param user
 * @return the list of booked flights for a spe@Override
	cific user
 */

List<Flight>  getFlights(String user);


/**
 * @return the list of booked flights
 */

	List<Flight>  getFlights();


/**
 *@param flight
 * @return information about a flight
 */

Flight  getFlightInformation(Flight flight);


}

	


