package datanucleus;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.AircraftDao;
import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Aircraft;

public class AircraftDaoImplTest {

	AircraftDao aircraftDao = DAO.getAircraftDao();
	Aircraft aircraft;
	long id;

	@Before
	public void addAircraftTest() {
		aircraft = new Aircraft();
		aircraft.setModel("SR-71 Blackbird");
		aircraft.setNumberOfPlaces(2);
		aircraft.setOwner("MUNIM");

		aircraftDao.addAircraft(aircraft);

		id = aircraft.getAircraftId();

	}

	@After
	public void deleteAircraftTest() {
		aircraftDao.deleteAircraft(id);
	}

	@Test
	public void getAircraftTest() {

		Aircraft outputAircraft = aircraftDao.getAircraft(id);

		Assert.assertEquals("MUNIM", outputAircraft.getOwner());

	}
}