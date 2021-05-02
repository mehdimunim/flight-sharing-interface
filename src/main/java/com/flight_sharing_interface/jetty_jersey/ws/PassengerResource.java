package com.flight_sharing_interface.jetty_jersey.ws;

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
import com.flight_sharing_interface.jetty_jersey.dao.objects.Passenger;

@Path("/PassengerResource")
public class PassengerResource {

	/**
	 * Add passenger to DB
	 * 
	 * @param passenger
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add-passenger")
	public long addPassenger(Passenger passenger) {

		if (passenger == null) {
			throw new BadRequestException("Missing payload");
		}
		if (DAO.getFlightDao() == null) {
			throw new BadRequestException("Missing actions in the container");
		}
		return DAO.getPassengerDao().addPassenger(passenger);
	}

	/**
	 * Fetch a passenger from DB
	 * 
	 * @param passengerId
	 * @return passenger
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/passenger-info/{id}")
	public Passenger getPassenger(@PathParam("id") long passengerId) {
		return DAO.getPassengerDao().getPassenger(passengerId);
	}

	/**
	 * Delete a passenger from DB
	 * 
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("delete-passenger/{id}")
	public void deletePassenger(@PathParam("id") long passengerId) {
		DAO.getPassengerDao().deletePassenger(passengerId);
	}

}
