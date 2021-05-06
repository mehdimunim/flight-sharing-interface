package com.flight_sharing_interface.jetty_jersey.dao_impl;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
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
	 * Add a specific aircraft to DB
	 * 
	 */

	public long addAircraft(Aircraft aircraft) {
		long aircraftId = aircraft.getAircraftId();
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
		return aircraftId;

	}

	/**
	 * Fetch an aircraft from DB with its id
	 */

	public Aircraft getAircraft(long aircraftId) {
		Aircraft aircraft;
		Aircraft detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			aircraft = pm.getObjectById(Aircraft.class, aircraftId);
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
	 * Delete an aircraft
	 */

	public void deleteAircraft(long aircraftId) {
		Aircraft aircraft;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			aircraft = pm.getObjectById(Aircraft.class, aircraftId);
			pm.deletePersistent(aircraft);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	public void editAircraft(Aircraft newAircraft) {
		long aircraftId = newAircraft.getAircraftId();
		Aircraft aircraft;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			// searching aircraft with the same id as newAircraft
			aircraft = pm.getObjectById(Aircraft.class, aircraftId);

			// updating aircraft's field
			aircraft.setModel(newAircraft.getModel());
			aircraft.setNumberOfPlaces(newAircraft.getNumberOfPlaces());
			aircraft.setOwner(newAircraft.getOwner());

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

}