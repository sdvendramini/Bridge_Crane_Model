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
        ControllerInterface model2 = new BridgeCraneController(bridgeCraneModel,false);
		
    	HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface model1 = new HeartController(heartModel,false);
        
        BeatModelInterface beatModel = new BeatModel();
		ControllerInterface model3 = new BeatController(beatModel,false);
        
    }
}