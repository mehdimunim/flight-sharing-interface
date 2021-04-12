package com.flight_sharing_interface.jetty_jersey.ws;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Booking;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Passenger;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Pilot;

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
		booking = new Booking();

		LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 07);
		List<Flight> fleet = new ArrayList<Flight>();
		Flight f1 = new Flight();
		f1.departure_aerodrome = "Madrid";
		f1.id = 124;
		f1.destination_aerodrome = "Paris";
		fleet.add(f1);
		Flight f2 = new Flight();
		f2.departure_aerodrome = "London";
		f2.id = 224;
		f2.destination_aerodrome = "Madrid";
		fleet.add(f2);
		Flight f3 = new Flight();
		f3.departure_aerodrome = "London";
		f3.id = 226;
		f3.destination_aerodrome = "Paris";
		fleet.add(f3);
		LocalDateTime date = LocalDateTime.of(2021, 3, 9, 18, 25, 00);
		Passenger passenger = new Passenger();
		passenger.first_name = "Mamadou";
		passenger.last_name = "DANSOKHO";
		passenger.civil_statut = "M";
		passenger.mail_adresse = "mamadou@email.com";
		passenger.number = (long) 0753;
		passenger.birthday = birthday;
		passenger.bookedFlights = fleet;
		booking.id = 10903;
		booking.date_time = date;
		booking.passenger = passenger;
		System.out.println("Booking information:\n" + booking);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/AllBookedFlights")

	/**
	 * @param f
	 * @return list of booked flights
	 */
	public List<Flight> getBookedFlights() {

		List<Flight> bookedflights = new ArrayList<Flight>();

		Flight f1 = new Flight();
		Flight f2 = new Flight();
		Flight f3 = new Flight();

		f1.departure_aerodrome = "London";
		f1.departureDateTime = LocalDateTime.of(2020, Month.MAY, 28, 19, 30, 00);
		f1.arrivalDateTime = LocalDateTime.of(2020, Month.MAY, 28, 20, 30, 00);
		f1.price = 100;
		f1.meeting_place = "EIDD flight meeting Place";
		f1.departure_aerodrome = "EIDD departure Aerodorme";
		f1.destination_aerodrome = " EIDD arrival aerodrome";
		f1.id = 930;
		f1.availabePlaces = 30;
		Pilot p1 = new Pilot("Dansokho", "Mamadou", "eidd fligh first shared flight");
		f1.pilot = p1;

		f2.departure_aerodrome = "London";
		f2.departureDateTime = LocalDateTime.of(2020, Month.MAY, 25, 19, 30, 00);
		f2.arrivalDateTime = LocalDateTime.of(2020, Month.MAY, 25, 20, 30, 00);
		f2.price = 100;
		f2.meeting_place = "EIDD flight meeting Place";
		f2.departure_aerodrome = "EIDD departure Aerodorme";
		f2.destination_aerodrome = " EIDD arrival aerodrome";
		f2.id = 931;
		f2.availabePlaces = 30;
		Pilot p2 = new Pilot("Boudalil", "Hassna", "eidd fligh first shared flight");
		f2.pilot = p2;

		f3.departure_aerodrome = "London";
		f3.departureDateTime = LocalDateTime.of(2020, Month.MAY, 20, 19, 30, 00);
		f3.arrivalDateTime = LocalDateTime.of(2020, Month.MAY, 20, 20, 30, 00);
		f3.price = 100;
		f3.meeting_place = "EIDD flight meeting Place";
		f3.departure_aerodrome = "EIDD departure Aerodorme";
		f3.destination_aerodrome = " EIDD arrival aerodrome";
		f3.id = 933;
		f3.availabePlaces = 30;
		Pilot p3 = new Pilot("Munim", "Mehdi", "eidd fligh first shared flight");
		f3.pilot = p3;

		List<Passenger> passengers1 = new ArrayList<Passenger>();
		List<Passenger> passengers2 = new ArrayList<Passenger>();
		List<Passenger> passengers3 = new ArrayList<Passenger>();

		Passenger pass1 = new Passenger("Hassna", "Boudalil", "F");

		Passenger pass2 = new Passenger("Mamadou", "Boudalil", "M");

		Passenger pass3 = new Passenger("Mehdi", "Munim", "M");

		passengers1.add(pass1);
		passengers1.add(pass3);

		passengers2.add(pass1);
		passengers2.add(pass3);

		passengers3.add(pass1);
		passengers3.add(pass2);

		f1.passengers = passengers1;
		f2.passengers = passengers2;
		f3.passengers = passengers3;

		bookedflights.add(f1);
		bookedflights.add(f2);
		bookedflights.add(f3);

		return bookedflights;

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Registration")

	public void register(Passenger passenger) {

		passenger = new Passenger("Mamadou", "DANSOKHO", "M");

		System.out.print("Hello" + "  " + passenger.first_name + " " + passenger.last_name + " "
				+ " Your registration is succesfull!:");

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/CancelBooking")

	public void cancelBooking(Booking booking) {

		Passenger passenger = new Passenger("Mamadou", "DANSOKHO", "M");

		LocalDateTime date_time = LocalDateTime.of(2020, Month.MAY, 20, 19, 30, 00);

		booking = new Booking(90321, date_time, passenger);

		System.out.print("Hello " + " " + passenger.first_name + " " + " " + passenger.last_name + " your booking "
				+ " " + booking.id + " has succesfully been deleted");

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Login")
	public void PassengerLogin() {
		// LoginUser user = new LoginUser();
		// user.username = "hassna";
		// user.password = "motdepasse";
		System.out.println("Logged successfully");

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/register")
	public void registration() {

		RegisterUser user = new RegisterUser();
		user.userName = "Hassna";
		user.userMobile = "065182";
		user.userEmail = "hassna.78";
		user.userAddress = "61 rue";

		System.out.println("User registered successfully");

	}

}
