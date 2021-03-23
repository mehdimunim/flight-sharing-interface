package datanucleus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.example.jetty_jersey.dao.Flight;
import com.example.jetty_jersey.dao.FlightDAO;
import com.example.jetty_jersey.dao.dn.FlightDaoImpl;

public class FlightDaoImplTest {
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");
	
	
	public List<Flight> flightGenerator(int nelements) {
		/**
		 * Generate a random list of flights of size nelements
		 */
		ArrayList<Flight> flights = new ArrayList<Flight>();
		for (int i = 0;i<nelements; i++) {
			
			Flight flight = new Flight();
			
			double random = Math.random();
			double price = 1000*random;
			int id = (int) (price);
			int places = (int) (100 * random);
			int year = 2021;
			int month = (int) (13*random) + 1;
			int day = (int) (28*random) + 1;
			int hour = (int) (25*random) + 1;
			int minutes = (int) (61*random) + 1;
			
			
			LocalDateTime departure = LocalDateTime.of
			
			
			flight.setMeeting_place("Neverland");
			flight.setPrice(price);
			flight.setId(id);
			flight.setAvailabePlaces(places);
			flight.setDepartureDateTime(null);
			flight.setDeparture_aerodrome("departure");
			flight.setArrivalDateTime(null);
			flight.setDestination_aerodrome("arrival");
			
			
		}
		return flights;
	}
	@Test
	public void getFlightInfoTest() {
		FlightDAO flightDAO = new FlightDaoImpl(pmf);
		
		Flight flight = new Flight();
		
		flight.setAvailabePlaces(200);
		flight.setId(100);
		
		flightDAO.addFlight(flight);
		
		List<Flight> list = flightDAO.getFlightInfo(100);
		Assert.assertEquals(1, list.size());
		System.out.print("hello");
		for (Flight f : list) {
			Assert.assertEquals(200, f.getAvailabePlaces());
		}
	}
		@Test
		public void getFlightsFromCriteria() {
			FlightDAO flightDAO = new FlightDaoImpl(pmf);
			
			Flight flight = new Flight();
			
			flight.setAvailabePlaces(200);
			flight.setId(100);
			
			flightDAO.addFlight(flight);
			
			List<Flight> list = flightDAO.getFlightInfo(100);
			Assert.assertEquals(1, list.size());
			System.out.print("hello");
			for (Flight f : list) {
				Assert.assertEquals(200, f.getAvailabePlaces());
			}	

	}

}
