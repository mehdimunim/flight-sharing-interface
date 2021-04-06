package com.flight_sharing_interface.jetty_jersey.dao.dn;

import java.util.List;

import javax.jdo.PersistenceManagerFactory;

import com.flight_sharing_interface.jetty_jersey.dao.PassengerDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Booking;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Passenger;

public class PassengerDaoImpl implements PassengerDao {
	private PersistenceManagerFactory pmf;

	public PassengerDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	public void bookFlights(List<Flight> flights) {
		// TODO Auto-generated method stub

	}

	public List<Flight> getBookedFlight() {
		// TODO Auto-generated method stub
		return null;
	}

	public void register(Passenger passenger) {
		// TODO Auto-generated method stub

	}

	public void cancelABooking(Booking booking) {
		// TODO Auto-generated method stub

	}

	public void loging(Passenger passenger) {
		// TODO Auto-generated method stub

	}

}
