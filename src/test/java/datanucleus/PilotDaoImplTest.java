package datanucleus;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.PilotDao;
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
	public void getPilotTest() {

		Pilot outputPilot = dao.getPilot(1);

		Assert.assertEquals("Biological Engineering", outputPilot.getQualifications());
	}

}
