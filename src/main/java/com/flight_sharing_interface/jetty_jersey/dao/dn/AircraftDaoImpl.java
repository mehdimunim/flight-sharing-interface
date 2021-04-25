package com.flight_sharing_interface.jetty_jersey.dao.dn;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
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

		List<Aircraft> actions = null;
		List<Aircraft> detached = new ArrayList<Aircraft>();

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String user");
			q.setFilter("username == user");

			actions = (List<Aircraft>) q.execute(username);
			detached = (List<Aircraft>) pm.detachCopyAll(actions);

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

	public Aircraft getAircraftInfo(long aircraftId) {

		PersistenceManager pm = pmf.getPersistenceManager();
		/**
		 * 
		 * Get an aircraft from the aircraft Id
		 * 
		 */

		try {
			Aircraft container = pm.getObjectById(Aircraft.class, aircraftId);
			Aircraft detached = pm.detachCopy(container);

			return detached;
		} catch (JDOObjectNotFoundException e) {
			return null;

		} finally {
			pm.close();
		}

	}

	public long addAircraftInfo(Aircraft aircraft) {

		PersistenceManager pm = pmf.getPersistenceManager();

		aircraft = pm.makePersistent(aircraft);
		long aircraftId = aircraft.getId();
		pm.close();

		return aircraftId;

	}

}