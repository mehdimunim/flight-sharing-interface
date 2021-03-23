package datanucleus;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.example.jetty_jersey.dao.Flight;
import com.example.jetty_jersey.dao.FlightDAO;
import com.example.jetty_jersey.dao.dn.FlightDaoImpl;

public class FlightDaoImplTest {
	


	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");
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
