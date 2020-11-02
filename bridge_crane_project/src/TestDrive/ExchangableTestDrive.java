package TestDrive;

import Controller.BridgeCraneController;
import Controller.ControllerInterface;
import Model.BridgeCraneModel;

public class ExchangableTestDrive {

	public static void main (String[] args) 
	{
		BridgeCraneModel bridgeCraneModel = new BridgeCraneModel();
<<<<<<< HEAD
        ControllerInterface model = new BridgeCraneController(bridgeCraneModel,true);
=======
        ControllerInterface model = new BridgeCraneController(bridgeCraneModel,2);
>>>>>>> origin/Third
	}

}
