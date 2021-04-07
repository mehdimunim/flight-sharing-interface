package com.example.jetty_jersey.dao.dn;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.example.jetty_jersey.dao.Aircraft;
import com.example.jetty_jersey.dao.AircraftDAO;

public class AircraftDaoImpl implements AircraftDAO {

	private PersistenceManagerFactory pmf;

	public AircraftDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

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
		Long aircraftId = aircraft.getId();
		pm.close();

		return aircraftId;
	}

}