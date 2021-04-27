package com.flight_sharing_interface.jetty_jersey.dao_impl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flight_sharing_interface.jetty_jersey.dao.FlightDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Booking;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;

public class FlightDaoImpl implements FlightDao {

	private PersistenceManagerFactory pmf;

	public FlightDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	// METHOD TO FETCH FLIGHTS

	/**
	 * Fetch flight with its id
	 */

	public Flight getFlight(long flightId) {

		Flight flight;
		Flight detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			flight = pm.getObjectById(Flight.class, flightId);
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
	 * Fetch flight from DB, with aircraftId, departure date and time
	 */

	public Flight getFlight(long aircraftId_, Date departureDate_, Time departureTime_) {

		Flight flight;
		Flight detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareImports("java.sql.Date, java.sql.Time");
			q.declareParameters("long aircraftId_, Date departureDate_, Time departureTime_ ");
			q.setFilter(
					"aircraftId == aircraftId_ && departureDate == departureDate_ && departureTime == departureTime_ ");
			q.setUnique(true);

			flight = (Flight) q.execute(aircraftId_, departureDate_, departureTime_);
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
	 * Get all flights
	 */

	@SuppressWarnings("unchecked")
	public List<Flight> getAllFlights() {

		List<Flight> flights;
		List<Flight> detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			flights = (List<Flight>) q.execute();
			detached = pm.detachCopy(flights);

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
	 * Get flights leaving at a given departure place
	 */
	@SuppressWarnings("unchecked")
	public List<Flight> getFlightsWithDeparture(String departureAerodrome_) {

		List<Flight> flights;
		List<Flight> detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("String departureAerodrome_");
			q.setFilter("departureAerodrome == departureAerodrome_");
			flights = (List<Flight>) q.execute(departureAerodrome_);
			detached = pm.detachCopy(flights);

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
	 * Get flights leaving at a given date and time
	 */

	@SuppressWarnings("unchecked")
	public List<Flight> getFlightsWithDateTime(Date departureDate_, Time departureTime_) {
		List<Flight> flights;
		List<Flight> detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareImports("import java.sql.Date, import java.sql.Time");

			q.declareParameters("Date departureDate_, Time departureTime_");

			q.setFilter("departureDate == departureDate_ && departureTime == departureTime_");

			flights = (List<Flight>) q.execute(departureDate_, departureTime_);
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
	 * Get flights with given meeting place
	 */

	@SuppressWarnings("unchecked")
	public List<Flight> getFlightsWithMeetingPlace(String meetingPlace_) {
		List<Flight> flights;
		List<Flight> detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("String meetingPlace_");
			q.setFilter("meetingPlace == meetingPlace_");
			flights = (List<Flight>) q.execute(meetingPlace_);
			detached = pm.detachCopy(flights);

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
	 * Get flights planned for the given pilot
	 */

	@SuppressWarnings("unchecked")
	public List<Flight> getPlannedFlights(long pilotId_) {
		List<Flight> flights;
		List<Flight> detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("long pilotId_");
			q.setFilter("pilotId == pilotId_");
			flights = (List<Flight>) q.execute(pilotId_);
			detached = pm.detachCopy(flights);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;

	}

	// METHOD TO ADD FLIGHTS
	/**
	 * Adding a flight to DB
	 */
	public void addFlight(Flight flight) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
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

	}

	// METHOD TO MODIFY FLIGHTS

	/**
	 * replace by newFlight the flight stored with the id given newFlight
	 */
	public void editFlight(Flight newFlight) {
		long flightId = newFlight.getId();
		Flight flight = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			// searching flight with the name id as newFlight
			flight = pm.getObjectById(Flight.class, flightId);
			pm.deletePersistent(flight);
			// replacing with newFlight (probably with different parameters
			pm.makePersistent(newFlight);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	// METHOD TO DELETE FLIGHTS

	/**
	 * Delete specific flight
	 */
	public void deleteFlight(long flightId) {
		Flight flight;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			flight = pm.getObjectById(Flight.class, flightId);
			pm.deletePersistent(flight);
			tx.commit();

		} finally {

			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	/**
	 * Delete all flights planned with the given aircraft
	 */

	@SuppressWarnings("unchecked")
	public void deleteFlightsWithAircraft(long aircraftId_) {

		List<Flight> flights;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("long aircraftId_");
			q.setFilter("aircraftId == aircraftId_");
			flights = (List<Flight>) q.execute(aircraftId_);
			pm.deletePersistentAll(flights);
			tx.commit();

		} finally {

			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	// OTHER METHODS

	/**
	 * Get available places
	 */
	@SuppressWarnings("unchecked")
	public int getAvailablePlaces(long flightId_) {
		int availablePlaces;
		List<Booking> bookings;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Booking.class);
			q.declareParameters("long flightId_");
			q.setFilter("flightId == flightId_");
			bookings = (List<Booking>) q.execute(flightId_);
			// the number of available places is the number of bookings for the flight
			availablePlaces = bookings.size();
			tx.commit();

		} finally {

			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return availablePlaces;

	}

}
