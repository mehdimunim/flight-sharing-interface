package com.flight_sharing_interface.jetty_jersey.dao.dn;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flight_sharing_interface.jetty_jersey.dao.AircraftDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Aircraft;

public class AircraftDaoImpl implements AircraftDao {

	private PersistenceManagerFactory pmf;

	public AircraftDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	/**
	 * 
	 * Get a list of aircrafts
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<Aircraft> getAircrafts(String username) {
		List<Aircraft> aircrafts = null;
		List<Aircraft> detached = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String username");
			q.setFilter("owner == username");

			aircrafts = (List<Aircraft>) q.execute(username);
			detached = (List<Aircraft>) pm.detachCopyAll(aircrafts);

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
	 * 
	 * Adds an aircraft to the current fleet
	 * 
	 */

	public void addAircraft(Aircraft aircraft) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(aircraft);

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
	 * Get an aircraft from the aircraft Id
	 * 
	 */

	public Aircraft getAircraftInfo(int aircraftId) {
		Aircraft aircraft = null;
		Aircraft detached = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int aircraftId");
			q.setFilter("id == aircraftId");
			q.setUnique(true);

			aircraft = (Aircraft) q.execute(aircraftId);
			detached = pm.detachCopy(aircraft);

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
	 * 
	 * Add aircraft information in the form of newAircraft
	 * 
	 */

	public void addAircraftInfo(Aircraft newAircraft) {
		Aircraft aircraft = null;
		int aircraftId = newAircraft.getId();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int aircraftId");
			q.setFilter("id == aircraftId");
			q.setUnique(true);

			aircraft = (Aircraft) q.execute(aircraftId);
			pm.deletePersistent(aircraft);

			pm.makePersistent(newAircraft);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

}