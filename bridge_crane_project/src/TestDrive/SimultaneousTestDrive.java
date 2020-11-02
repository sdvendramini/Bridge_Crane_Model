package TestDrive;

import Controller.BeatController;
import Controller.BridgeCraneController;
import Controller.ControllerInterface;
import Controller.HeartController;
import Model.BeatModel;
import Model.BeatModelInterface;
import Model.BridgeCraneModel;
import Model.HeartModel;
  
public class SimultaneousTestDrive {

    public static void main (String[] args) {
    	
    	BridgeCraneModel bridgeCraneModel = new BridgeCraneModel();
<<<<<<< HEAD:bridge_crane_project/src/TestDrive/SimultaneousTestDrive.java
        ControllerInterface model2 = new BridgeCraneController(bridgeCraneModel,false);
		
    	HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface model1 = new HeartController(heartModel,false);
        
        BeatModelInterface beatModel = new BeatModel();
		ControllerInterface model3 = new BeatController(beatModel,false);
=======
        ControllerInterface model2 = new BridgeCraneController(bridgeCraneModel,1);
		
    	HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface model1 = new HeartController(heartModel,1);
        
        BeatModelInterface beatModel = new BeatModel();
		ControllerInterface model3 = new BeatController(beatModel,1);
>>>>>>> origin/Third:heartbeat_project/src/combined/djview/SimultaneousTestDrive.java
        
    }
}