package com.flight_sharing_interface.jetty_jersey.dao.dn;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flight_sharing_interface.jetty_jersey.dao.PassengerDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Passenger;

public class PassengerDaoImpl implements PassengerDao {
	private PersistenceManagerFactory pmf;

	public PassengerDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	/**
	 * 
	 * Book a list of flights
	 * 
	 */

	public void bookFlights(int passengerId, List<Flight> flights) {
		Passenger passenger;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("int passengerId");
			q.setFilter("id == passengerId");
			// setUnique to get at most one passenger
			// and not a list of passenger
			q.setUnique(true);

			passenger = (Passenger) q.execute(passengerId);
			passenger.setBookedFlights(flights);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	/**
	 * 
	 * Return the list of flights booked by passenger
	 * 
	 */

	public List<Flight> getBookedFlight(int passengerId) {
		Passenger passenger;
		Passenger detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("int passengerId");
			q.setFilter("id == passengerId");
			// setUnique to get at most one passenger
			// and not a list of passenger
			q.setUnique(true);

			passenger = (Passenger) q.execute(passengerId);
			detached = pm.detachCopy(passenger);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getBookedFlights();
	}

	/**
	 * 
	 * Add passenger to DB
	 * 
	 */

	public void register(Passenger passenger) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(passenger);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}

	/**
	 * 
	 * Cancel a booking
	 * 
	 */

	public void cancelABooking(int passengerId, Flight booking) {
		// TODO: problem to make booking/flight corresponds
		Passenger passenger;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("int passengerId");
			q.setFilter("id == passengerId");
			// setUnique to get at most one passenger
			// and not a list of passenger
			q.setUnique(true);

			passenger = (Passenger) q.execute(passengerId);
			passenger.getBookedFlights().remove(booking);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	/**
	 * 
	 * Log a passenger
	 * 
	 * @return if the logging was successful or not
	 * 
	 */

	public Passenger loging(int passengerId) {

		Passenger passenger;
		Passenger detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("int passengerId");
			q.setFilter("id == passengerId");
			// setUnique to get at most one passenger
			// and not a list of passenger
			q.setUnique(true);

			passenger = (Passenger) q.execute(passengerId);
			detached = pm.detachCopy(passenger);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	@SuppressWarnings("unchecked")
	public List<Passenger> clearDB() {

		List<Passenger> passengers = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);

			passengers = (List<Passenger>) q.execute();
			pm.deletePersistentAll(passengers);

			tx.commit();

		}

		finally {

			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return passengers;
	}

}
