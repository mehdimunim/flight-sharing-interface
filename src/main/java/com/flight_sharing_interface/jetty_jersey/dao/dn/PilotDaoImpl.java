package com.flight_sharing_interface.jetty_jersey.dao.dn;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flight_sharing_interface.jetty_jersey.dao.PilotDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Pilot;

public class PilotDaoImpl implements PilotDao {
	private PersistenceManagerFactory pmf;

	public PilotDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	/**
	 * 
	 * Put flight in DB
	 * 
	 */

	public void putFlight(Flight flight) {
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
	 * 
	 * Post a flight
	 * 
	 */

	public void postFlightInformation(Flight flight) {
		// TODO Auto-generated method stub

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

	/**
	 * 
	 * Return all flights planned for the given pilot
	 * 
	 */

	public List<Flight> getFlightsPlanned(int pilotId) {

		Pilot pilot = null;
		Pilot detached = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("int pilotId");
			q.setFilter("id == pilotId");
			q.setUnique(true);

			pilot = (Pilot) q.execute(pilotId);
			detached = pm.detachCopy(pilot);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getFlightList();
	}

}
