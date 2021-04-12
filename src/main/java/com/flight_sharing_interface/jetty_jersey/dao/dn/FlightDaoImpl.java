package com.flight_sharing_interface.jetty_jersey.dao.dn;

import java.time.LocalDateTime;
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

			// unable to cast directly q.exectute(...) in Flight

			List<Flight> list = (List<Flight>) q.execute(flightId);
			if (list.size() != 0) {
				flight = list.get(0);
			}

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

			// q.declareParameters(
			// "String departure_aerodrome_, LocalDateTime departureDateTime_, LocalDateTime
			// arrivalDateTime_");
			q.declareParameters("LocalDateTime departureDateTime_");

			// selecting flights by three criteria
			// q.setFilter(
			// "departure_aerodrome == departure_aerodrome_ && departureDateTime ==
			// departureDateTime_ && arrivalDateTime == arrivalDateTime_ ");
			q.setFilter("departureDateTime == departureDateTime_");

			// flights = (List<Flight>) q.execute(departure_aerodrome_, departureDateTime_,
			// arrivalDateTime_);
			flights = (List<Flight>) q.execute(departureDateTime_);
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

//HASSNA :

	public List<Flight> getFlightsFromCriteria(FlightResource.flightsFromCriteria flights) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Editing flight
	 */
	public void editFlight(int flightId) {
		// TODO Auto-generated method stub

		Flight flight = null;
		Flight detached = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			int flightId = newFlight.getId();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("int flightId");
			q.setFilter("id == flightId");

			List<Flight> list = (List<Flight>) q.execute(flightId);
			if (list.size() != 0) {
				flight = list.get(0);
			}

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

}
