package com.example.jetty_jersey.dao.dn;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.example.jetty_jersey.dao.Flight;
import com.example.jetty_jersey.dao.FlightDAO;
import com.example.jetty_jersey.dao.Pilot;

public class FlightDaoImpl implements FlightDAO {

	private PersistenceManagerFactory pmf;

	public FlightDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	// CHANGEMENT DE HASSNA : la fonction return Flight et qlqs autres petit details
	// pr faire fonctionner
	// pcq j'ai rencontré des problèmes avec detached
	@SuppressWarnings("unchecked")
	public Flight getFlightInfo(int flightId) {
		/**
		 * Getting the flights corresponding to the given flightId
		 */
		Flight flight;

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			flight = pm.getObjectById(Flight.class, flightId);

			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

		return flight;

		/*
		 * MEHDI'S VERSION : public Flight getFlightInfo(int flightId) { List<Flight>
		 * flights = null; List<Flight> detached = new ArrayList<Flight>();
		 * PersistenceManager pm = pmf.getPersistenceManager(); Transaction tx =
		 * pm.currentTransaction(); try { tx.begin(); Query q =
		 * pm.newQuery(Flight.class); q.declareParameters("int flightId");
		 * q.setFilter("id == flightId");
		 * 
		 * flights = (List<Flight>) q.execute(flightId); detached = (List<Flight>)
		 * pm.detachCopyAll(flights);
		 * 
		 * tx.commit(); } finally { if (tx.isActive()) { tx.rollback(); } pm.close(); }
		 * return detached;
		 * 
		 * 
		 */
	}

	@SuppressWarnings("unchecked")
	public List<Flight> getFlightsFromCriteria(String departure_aerodrome_, LocalDateTime departureDateTime_,
			LocalDateTime arrivalDateTime_) {
		/**
		 * Selecting flights leaving the airport departure_aerodrome at
		 * departureDataTime_ and arriving a arrivalDateTime_
		 */
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
	 * Problem choosing what to edit
	 */

	public void editFlight(int flightId) {
		/**
		 * Editing flight "flightId"
		 */
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
		System.out.println("flight information has been changed. Flight ID :  " + flightId);

	}

	public void addFlight(int pilotId) {
		/**
		 * Adding the flight with pilotId
		 */
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Flight flight = new Flight();
			Pilot pilot = new Pilot();
			pilot.setId(pilotId);
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

	public void addFlight(Flight flight) {
		/**
		 * Adding a flight
		 */
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

	// CHANGEMENT HASSNA : du return en void
	@SuppressWarnings("unchecked")
	public void deleteFlight(int flightId) {
		/**
		 * Deleting flight with flightId
		 */
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
		System.out.println("The flight " + flightId + " has been deleted");
		// return flights;

	}

}
