package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Action;
import com.flight_sharing_interface.jetty_jersey.dao.objects.ActionContainer;

public class ActionContainerTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");
		Long containerId = null;

		// Save a container with 3 actions
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			Action action1 = new Action("Title 1");
			Action action2 = new Action("Title 2");
			Action action3 = new Action("Title 3");

			ActionContainer container = new ActionContainer();
			container.getActions().add(action1);
			container.getActions().add(action2);
			container.getActions().add(action3);

			container = pm.makePersistent(container);
			containerId = container.getId();
			pm.close();
		}

		// Retrieve this container
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			ActionContainer container = pm.getObjectById(ActionContainer.class, containerId);
			Assert.assertEquals(3, container.getActions().size());

			pm.close();
		}

		pmf.close();
	}

}
