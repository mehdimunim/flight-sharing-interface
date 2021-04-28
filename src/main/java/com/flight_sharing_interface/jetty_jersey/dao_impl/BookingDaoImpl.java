package com.flight_sharing_interface.jetty_jersey.dao_impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.flight_sharing_interface.jetty_jersey.dao.BookingDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Booking;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;

public class BookingDaoImpl implements BookingDao {

	private PersistenceManagerFactory pmf;

	public BookingDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	/**
	 * 
	 * Add a booking to DB
	 * 
	 */

	public long addBooking(Booking booking) {
		long bookingId = booking.getBookingId();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(booking);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return bookingId;

	}

	/**
	 * Fetch an booking from DB with its id
	 */

	public Booking getBooking(long bookingId) {
		Booking booking;
		Booking detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			booking = pm.getObjectById(Booking.class, bookingId);
			detached = pm.detachCopy(booking);
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
	 * Fetch bookings done by the given passenger
	 */

	@SuppressWarnings("unchecked")
	public List<Booking> getBookings(long passengerId_) {

		List<Booking> bookings;
		List<Booking> detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("long passengerId_");
			q.setFilter("passengerId == passengerId_");
			bookings = (List<Booking>) q.execute(passengerId_);
			detached = pm.detachCopy(bookings);
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
	 * Delete an booking
	 */

	public void cancelBooking(long bookingId) {
		Booking booking;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			booking = pm.getObjectById(Booking.class, bookingId);
			pm.deletePersistent(booking);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}
}
