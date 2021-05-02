package com.flight_sharing_interface.jetty_jersey.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Booking;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Passenger;

@Path("/flight-sharing/PassengerResource")
public class PassengerResource {

	// @JsonIgnoreProperties(ignoreUnknown = true)
	public static class Login {
		public String username;
		public String password;
	}

	public static class RegisterUser {
		public String userName;
		public String userMobile;
		public String userEmail;
		public String userAddress;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/bookingFlights")

	public long bookFlight(Booking booking) {

		return DAO.getBookingDao().addBooking(booking);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/AllBookedFlights")

	/**
	 * @param f
	 * @return list of booked flights
	 */
	public List<Flight> getBookedFlights() {

		// ???

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Registration")

	public void register(Passenger passenger) {

		DAO.getPassengerDao().addPassenger(passenger);

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/CancelBooking")

	public void cancelBooking(long bookingId) {

		DAO.getBookingDao().cancelBooking(bookingId);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Login")
	public void PassengerLogin(long passengerId) {
		DAO.getPassengerDao().getPassenger(passengerId);

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/register")
	public void registration(Passenger passenger) {

		DAO.getPassengerDao().addPassenger(passenger);
	}

}
