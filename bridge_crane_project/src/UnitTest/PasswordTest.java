package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.BridgeCraneController;
import Model.BridgeCraneModel;

public class PasswordTest {

	@Test
	public void rightPassWordTest() 
	{
		BridgeCraneModel model = new BridgeCraneModel();
<<<<<<< HEAD
		BridgeCraneController controller = new BridgeCraneController(model,false);
=======
		BridgeCraneController controller = new BridgeCraneController(model,1);
>>>>>>> origin/Third
		
		int rightPassword = 1234;
		int expected = -20;
		
		controller.setBPM(rightPassword);

		assertEquals(expected,model.getBPM());
	}
	
	@Test
	public void wrongPasswordTest() 
	{
		BridgeCraneModel model = new BridgeCraneModel();
<<<<<<< HEAD
		BridgeCraneController controller = new BridgeCraneController(model,false);
=======
		BridgeCraneController controller = new BridgeCraneController(model,1);
>>>>>>> origin/Third
		
		int wrongPassword = 5554;
		int expected = -10;
		
		controller.setBPM(wrongPassword);
		assertEquals(expected,model.getBPM());
	}

}
