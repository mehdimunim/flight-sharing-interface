package com.example.jetty_jersey.dao.dn;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.example.jetty_jersey.dao.FlightDao;
import com.example.jetty_jersey.dao.objects.Flight;
import com.example.jetty_jersey.dao.objects.Pilot;

public class FlightDaoImpl implements FlightDao {

	private PersistenceManagerFactory pmf;

	public FlightDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	/**
	 * Getting the flights corresponding to the given flightId
	 */
	@SuppressWarnings("unchecked")
	public Flight getFlightInfo(int flightId) {

		Flight flight = null;
		Flight detached = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("int flightId");
			q.setFilter("id == flightId");

			flight = ((List<Flight>) q.execute(flightId)).get(0);
			detached = (Flight) pm.detachCopy(flight);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	/**
	 * Selecting flights leaving the airport departure_aerodrome at
	 * departureDataTime_ and arriving a arrivalDateTime_
	 */

	@SuppressWarnings("unchecked")
	public List<Flight> getFlightsFromCriteria(String departure_aerodrome_, LocalDateTime departureDateTime_,
			LocalDateTime arrivalDateTime_) {

		List<Flight> flights = null;
		List<Flight> detached = new ArrayList<Flight>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareImports("import java.time.LocalDateTime");
			q.declareParameters(
					"String departure_aerodrome_, LocalDateTime departureDateTime_, LocalDateTime arrivalDateTime_");
			// selecting flights by three criteria
			q.setFilter(
					"departure_aerodrome == departure_aerodrome_ && departureDateTime == departureDateTime_ && arrivalDateTime == arrivalDateTime_ ");

			flights = (List<Flight>) q.execute(departure_aerodrome_, departureDateTime_, arrivalDateTime_);
			detached = (List<Flight>) pm.detachCopyAll(flights);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	/**
	 * Editing flight "flightId"
	 */
	public void editFlight(int flightId) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Flight flight = new Flight();
			Pilot pilot = new Pilot();
			pilot.setId(0);
			flight.setPilot(pilot);
			pm.makePersistent(flight);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	/**
	 * Adding a flight
	 */
	public void addFlight(Flight flight) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(flight);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	/**
	 * Deleting flight with flightId
	 */
	@SuppressWarnings("unchecked")
	public List<Flight> deleteFlight(int flightId) {

		List<Flight> flights = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			Query q = pm.newQuery(Flight.class);
			q.declareParameters("int flightId");
			q.setFilter("id == flightId");

			flights = (List<Flight>) q.execute(flightId);
			pm.deletePersistentAll(flights);

			tx.commit();

		}

		finally {

			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return flights;

	}

	public void addFlight(int pilotId) {
		// TODO Auto-generated method stub

	}

}
