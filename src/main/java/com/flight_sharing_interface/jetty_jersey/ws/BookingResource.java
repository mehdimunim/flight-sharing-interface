package com.flight_sharing_interface.jetty_jersey.ws;

import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Booking;

@Path("/BookingResource")
public class BookingResource {

	/**
	 * Fetch a booking from DB
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/booking-info/{id}")
	public Booking getBooking(@PathParam("id") long bookingId) {
		return DAO.getBookingDao().getBooking(bookingId);
	}

	/**
	 * Add a booking to DB
	 * 
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add-booking")
	public long addBooking(Booking booking) {

		if (booking == null) {
			throw new BadRequestException("Missing payload");
		}
		if (DAO.getBookingDao() == null) {
			throw new BadRequestException("Missing actions in the container");
		}
		return DAO.getBookingDao().addBooking(booking);
	}

	/**
	 * Fetch bookings done by the given passenger
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/bookings/{id}")
	public List<Booking> getBookings(@PathParam("id") long passengerId) {
		return DAO.getBookingDao().getBookings(passengerId);
	}

	/**
	 * Cancel a booking
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("delete-boooking/{id}")
	public void cancelBooking(@PathParam("id") long bookingId) {
		DAO.getBookingDao().cancelBooking(bookingId);
	}

}
