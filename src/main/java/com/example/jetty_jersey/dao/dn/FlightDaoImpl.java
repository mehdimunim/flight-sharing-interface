package com.example.jetty_jersey.dao.dn;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.example.jetty_jersey.dao.Flight;
import com.example.jetty_jersey.dao.FlightDAO;
import com.example.jetty_jersey.dao.Pilot;

public class FlightDaoImpl implements FlightDAO {


	private PersistenceManagerFactory pmf;

	public FlightDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> getFlightInfo(int flightId) {
		List<Flight> flight = null;
		List<Flight> detached = new ArrayList<>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("int flightId");
			q.setFilter("id == flightId");

			flight = (List<Flight>) q.execute(flightId);
			detached = (List<Flight>) pm.detachCopy(flight);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	@Override
	public List<Flight> getFlighsFromCriteria(String departure_aerodrome, LocalDateTime departureDateTime,
			LocalDateTime arrivalDateTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editFlight(int flightId) {
		// TODO Auto-generated method stub
		
	}
/**
 * 
 * Problem with addFlight() method
 * 
 */
	@Override
	public void addFlight(int pilotId) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Flight flight = new Flight();
			Pilot pilot = new Pilot();
			pilot.setId(pilotId);
			flight.setPilot(pilot);
			pm.makePersistent(flight);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}
	
	// New method created for a test
	@Override
	public void addFlight(Flight flight) {
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

	@Override
	public void deleteFlight(int flightId) {
		Flight flight = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("int flightId");
			q.setFilter("id == flightId");

			flight = (Flight) q.execute(flightId);
			pm.deletePersistent(flight);
			
			tx.commit();
			
		}
		
		finally {
			
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		// TODO Auto-generated method stub
		
	}

}
