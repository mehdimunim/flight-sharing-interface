package datanucleus;

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
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight Sharing Interface");
		FlightDAO flightDAO = new FlightDaoImpl(pmf);

		Assert.assertEquals(0, flightDAO.getFlightInfo(0).size());

		Flight flight = new Flight();
		flight.setMeeting_place("Drancy");
		flight.setId(42);
		flight.setAvailabePlaces(1);

		flightDAO.addFlight(flight);

		Assert.assertEquals(1, flightDAO.getFlightInfo(flight.getId()).size());

	}

}
