package TestDrive;

import Controller.BridgeCraneController;
import Controller.ControllerInterface;
import Model.BridgeCraneModel;

public class BridgeCraneTestDrive {

	public static void main (String[] args) {
		BridgeCraneModel bridgeCraneModel = new BridgeCraneModel();
<<<<<<< HEAD:bridge_crane_project/src/TestDrive/BridgeCraneTestDrive.java
        ControllerInterface model = new BridgeCraneController(bridgeCraneModel,false);
=======
        ControllerInterface model = new BridgeCraneController(bridgeCraneModel,1);
>>>>>>> origin/Third:heartbeat_project/src/combined/djview/BridgeCraneTestDrive.java
	}
}