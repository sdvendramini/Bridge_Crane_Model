package TestDrive;

import Controller.ControllerInterface;
import Controller.HeartController;
import Model.HeartModel;
  
public class HeartTestDrive {

    public static void main (String[] args) {
		HeartModel heartModel = HeartModel.getInstance();
<<<<<<< HEAD:bridge_crane_project/src/TestDrive/HeartTestDrive.java
        ControllerInterface model = new HeartController(heartModel,false);
=======
        ControllerInterface model = new HeartController(heartModel,1);
>>>>>>> origin/Third:heartbeat_project/src/combined/djview/HeartTestDrive.java
    }
}
