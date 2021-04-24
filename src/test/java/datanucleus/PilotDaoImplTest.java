package datanucleus;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.PilotDao;
import com.flight_sharing_interface.jetty_jersey.dao.dn.PilotDaoImpl;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Pilot;

public class PilotDaoImplTest {
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");
	PilotDao dao = new PilotDaoImpl(pmf);
	Pilot pilot;

	@Before
	public void init() {

		pilot = new Pilot();

		pilot.setId(1);

		pilot.setExperience("Infinity");
		pilot.setFlightInformation("Heeeelo!");

		dao.register(pilot);

	}

	@After
	public void clear() {

		dao.clearDB();

	}

	@Test
	public void test() {

		Flight flight1 = new Flight();
		Flight flight2 = new Flight();

		flight1.setId(10);
		flight1.setPilot(pilot);

		flight2.setId(11);
		flight2.setPilot(pilot);

		dao.putFlight(flight1);
		dao.putFlight(flight2);

		List<Flight> list1 = dao.getPlannedFlights(0);
		List<Flight> list2 = dao.getPlannedFlights(1);

		Assert.assertEquals(list1.size(), 0);
		Assert.assertEquals(list2.size(), 2);
	}

}
