package com.flight_sharing_interface.jetty_jersey.dao_impl;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flight_sharing_interface.jetty_jersey.dao.PassengerDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Passenger;

public class PassengerDaoImpl implements PassengerDao {
	private PersistenceManagerFactory pmf;

	public PassengerDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	/**
	 * 
	 * Add passenger to DB
	 * 
	 */

	public void addPassenger(Passenger passenger) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(passenger);

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
	 * Fetch a passenger from DB
	 * 
	 */

	public Passenger getPassenger(long passengerId) {

		Passenger passenger;
		Passenger detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("int passengerId");
			q.setFilter("id == passengerId");
			// setUnique to get at most one passenger
			// and not a list of passenger
			q.setUnique(true);

			passenger = (Passenger) q.execute(passengerId);
			detached = pm.detachCopy(passenger);

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
	 * Delete a passenger from DB
	 * 
	 */

	public void deletePassenger(long passengerId) {
		Passenger passenger;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("int passengerId");
			q.setFilter("id == passengerId");
			// setUnique to get at most one passenger
			// and not a list of passenger
			q.setUnique(true);

			passenger = (Passenger) q.execute(passengerId);
			pm.deletePersistent(passenger);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}
}
