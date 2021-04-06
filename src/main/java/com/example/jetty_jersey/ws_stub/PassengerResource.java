package com.example.jetty_jersey.ws_stub;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.jetty_jersey.dao.objects.Flight;
import com.example.jetty_jersey.dao.objects.Passenger;
import com.example.jetty_jersey.dao.objects.Pilot;

@Path("/PassengerResource")
public class PassengerResource {
	
	
	public static class Login {
		public String username;
		public String password;
	}
	
	public static class Register {
		public String name;
		public String mobile;
		public String email;
		public String address;
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight")
	
	public List<Flight> getFlightsInfo(){
		List<Flight> flights = new ArrayList<Flight>();
		Flight f1 = new Flight();
		f1.departure_aerodrome = "Madrid";
		f1.id = 124;
		f1.destination_aerodrome = "Paris";
		flights.add(f1);
		Flight f2 = new Flight();
		f2.departure_aerodrome = "London";
		f2.id = 224;
		f2.destination_aerodrome = "Madrid";
		flights.add(f2);
		Flight f3= new Flight();
		f3.departure_aerodrome = "London";
		f3.id = 226;
		f3.destination_aerodrome = "Paris";
		flights.add(f3);
		
		
		return flights;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight1")

	/**
	 * @param f
	 * @return a flight information
	 */
	public Flight getAllIFlightInformation() {
		Flight f = new Flight();
//		f.departureDate = LocalDate.of(2021,Month.MARCH,1);
//		f.arrivalDate= LocalDate.of(2021,Month.MARCH,1);
//		f.departureTime = LocalDateTime.of(2021,03,1,10,30,00);
//		f.arrivalTime = LocalDateTime.of(2021,03,1,12,30,00);
		f.price = 100;
		f.meeting_place = "EIDD flight meeting Place";
		f.departure_aerodrome= "EIDD departure Aerodorme";
		f.destination_aerodrome = " EIDD arrival aerodrome";
		f.id= 930;
		f.availabePlaces = 30;
	//	f.duration = Duration.ofHours(2);
		Pilot p1 = new Pilot("Dansokho","Mamadou","eidd fligh first shared flight");
		f.pilot = p1;
		List<Passenger> passengers1 = new ArrayList<Passenger>();
		Passenger p11 = new Passenger("Hassna","Boudalil","F");
		passengers1.add(p11);
		Passenger p2 = new Passenger("Mamadou","Boudalil","M");
		passengers1.add(p2);
		Passenger p3 = new Passenger("Mehdi","Munim","M");
		passengers1.add(p3);
		f.passengers = passengers1;
		
		return f;

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight2")
	
	
	public Flight getFlightWithSpecificInfo() {
		
//		Flight f1 = new Flight();
//		f1.departureTime = LocalDateTime.of(2021,03,1,10,30,00);
//		f1.arrivalTime = LocalDateTime.of(2021,03,1,12,30,00);
//		f1.price = 100;
		
//		return f1;
		return null;
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/flight3")
	
	public void searchFlightWithSpecificInfo(Flight f2) {
//		f2.departureTime = LocalDateTime.of(2021,03,1,10,30,00);
//		f2.arrivalTime = LocalDateTime.of(2021,03,1,12,30,00);
//		f2.price = 100;
//		
//		System.out.println("Flight information:"+ f2.departureDate + f2.arrivalDate+f2.price);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight4")
	
	public  void searchFlight(Flight f4) {
		
		System.out.print("Found flight:"+f4);
		
		}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight-sharing/flights")
	public List<Flight> getFlight() {
		List<Flight>  fleet = new ArrayList<Flight>();
		 
		 Flight f1 = new Flight();
		 f1.id = 124;
		 f1.departure_aerodrome = "London";
		 fleet.add(f1);
		
		 Flight f2 = new Flight();
		 f2.id = 255;
		 f2.departure_aerodrome = "Marseille";
		 fleet.add(f2);

		return fleet;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Usernames")
	public Login  getUsername() {
		Login user = new Login();
		user.username = "Munim";
		return user;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/LoginForm")
	public void PassengerLogin(Login login) {
		System.out.println("Account ID :  " + login.username + "Password : " + login.password);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/RegisterForm")
	public void PassengerRegister(Register register) {
		System.out.println("Name :  " + register.name + "Mobile : "  + register.mobile + "Email : "+register.email);
	}
	
	
	
}