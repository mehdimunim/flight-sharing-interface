package com.flight_sharing_interface.jetty_jersey.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/bookingFlights")

	public void bookFlight(Booking booking) {
		DAO.getPassengerDao().bookFlights(0, getBookedFlights());
		;

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/AllBookedFlights")

	/**
	 * @param f
	 * @return list of booked flights
	 */
	public List<Flight> getBookedFlights() {

		return DAO.getPassengerDao().getBookedFlight(0);

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Registration")

	public void register(Passenger passenger) {

		DAO.getPassengerDao().register(passenger);

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/CancelBooking")

	public void cancelBooking(Booking booking) {

		// incohérence entre CancelABooking et cancelBooking
		// DAO.getPassengerDao().cancelABooking(0, booking);

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Login")
	public void PassengerLogin() {
		DAO.getPassengerDao().login(0);

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/register")
	public void registration() {

		// Pas la même chose que register ???
		DAO.getPassengerDao().register(passenger);
	}

}
