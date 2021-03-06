package com.flight_sharing_interface.jetty_jersey.dao_impl;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.flight_sharing_interface.jetty_jersey.dao.PilotDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Pilot;

public class PilotDaoImpl implements PilotDao {
	private PersistenceManagerFactory pmf;

	public PilotDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	/**
	 * Add pilot to DB
	 * 
	 * @param pilot
	 */

	public long addPilot(Pilot pilot) {
		long pilotId = pilot.getPilotId();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(pilot);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return pilotId;
	}

	/**
	 * Fetch a pilot from DB
	 */

	public Pilot getPilot(long pilotId) {
		Pilot pilot;
		Pilot detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pilot = pm.getObjectById(Pilot.class, pilotId);
			detached = pm.detachCopy(pilot);
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
	 * Delete pilot from DB
	 */

	public void deletePilot(long pilotId) {
		Pilot pilot;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pilot = pm.getObjectById(Pilot.class, pilotId);
			pm.deletePersistent(pilot);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

}
