package com.example.jetty_jersey.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import com.example.jetty_jersey.dao.dn.AircraftDaoImpl;
import com.example.jetty_jersey.dao.dn.FlightDaoImpl;

public class DAO {

	private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");

	public static FlightDAO getFlightDao() {
		return new FlightDaoImpl(pmf);
	}

	public static AircraftDAO getAircraftDao() {
		return new AircraftDaoImpl(pmf);
	}

	/*
	 * 
	 * public static PassengerDAO getPassengerDao() { return new
	 * PassengerDaoImpl(pmf); }
	 * 
	 * public static PilotDAO getPilotDao() { return new PilotDaoImpl(pmf); }
	 * 
	 *
	 * 
	 */
}
