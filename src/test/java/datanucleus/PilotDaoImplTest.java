package datanucleus;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.PilotDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Pilot;

public class PilotDaoImplTest {
	PilotDao dao = DAO.getPilotDao();
	Pilot pilot;

	@Before
	public void addPilotTest() {

		pilot = new Pilot();

		pilot.setFirstName("Mehdi");
		pilot.setLastName("Munim");
		pilot.setExperience("Hate planes except in video games");
		pilot.setCivilStatut("Umm... let's skip this question...");
		pilot.setQualifications("Biological Engineering");
		pilot.setNumberflightHour(0);

		dao.addPilot(pilot);

	}

	@After
	public void deletePilotTest() {

		dao.deletePilot(1);

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
