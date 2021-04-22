package com.flight_sharing_interface.jetty_jersey.dao.dn;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flight_sharing_interface.jetty_jersey.dao.FlightDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Pilot;
import com.flight_sharing_interface.jetty_jersey.ws.FlightResource;

public class FlightDaoImpl implements FlightDao {

	private PersistenceManagerFactory pmf;

	public FlightDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	// TODO: SUperclass DAOImpl where the DB can be deleted
	/**
	 * Getting the flights corresponding to the given flightId
	 */
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
			q.setUnique(true);

			flight = (Flight) q.execute(flightId);
			detached = pm.detachCopy(flight);

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
	public List<Flight> getFlightsFromCriteria(FlightResource.flightsFromCriteria criteria) {
		String departure_aerodrome_ = criteria.departure_aerodrome;
		LocalDate departureDateTime_ = criteria.departureDate;
		LocalDate arrivalDateTime_ = criteria.arrivalDate;

		List<Flight> flights = new ArrayList<Flight>();
		List<Flight> detached = new ArrayList<Flight>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareImports("import java.time.LocalDate");

			q.declareParameters("String departure_aerodrome_, LocalDate departureDate_, LocalDate arrivalDate_");

			// selecting flights by three criteria
			q.setFilter(
					"departure_aerodrome == departure_aerodrome_ && departureDate == departureDate_ && arrivalDate == arrivalDate_ ");

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

	@SuppressWarnings("unchecked")
	public List<Flight> getFlightsFromCriteria(String departure_aerodrome_, LocalDate departureDateTime__,
			LocalDate arrivalDateTime__) {

		// Transforming LocalDates to SQL date that we are able to stored in DB
		Date departureDateTime_ = Date.valueOf(departureDateTime__);
		Date arrivalDateTime_ = Date.valueOf(arrivalDateTime__);

		List<Flight> flights = new ArrayList<Flight>();
		List<Flight> detached = new ArrayList<Flight>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareImports("import java.sql.Date");

			q.declareParameters("String departure_aerodrome_, Date departureDate_, Date arrivalDate_");

			// selecting flights by three criteria
			q.setFilter(
					"departure_aerodrome == departure_aerodrome_ && departureDate == departureDate_ && arrivalDate == arrivalDate_ ");

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
	 * Editing flight
	 */
	public void editFlight(int flightId) {
		// TODO: change parameters
		Flight flight = null;
		Flight detached = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Flight.class);
			q.declareParameters("int flightId");
			q.setFilter("id == flightId");
			q.setUnique(true);

			flight = (Flight) q.execute(flightId);
			detached = pm.detachCopy(flight);

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
	 * 
	 * Seems to destroy the entry
	 * 
	 * Unable to make persistent a deep copy of entry
	 */
	public int addFlight(Flight flight) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		int flightId = flight.getId();
		;
		try {
			tx.begin();

			flight = pm.makePersistent(flight);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return flightId;

	}

	/**
	 * Deleting flight with flightId
	 */
	@SuppressWarnings("unchecked")
	public void deleteFlight(int flightId) {

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

	}

	public void addFlight(int pilotId) {
		// avoid destroying flight
		Flight flight = new Flight();
		flight.setPilot(new Pilot());

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

	@SuppressWarnings("unchecked")
	public List<Flight> clearDB() {

		List<Flight> flights = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			Query q = pm.newQuery(Flight.class);

			flights = (List<Flight>) q.execute();
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

}
