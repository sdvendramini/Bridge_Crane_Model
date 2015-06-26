package combined.djview;
  
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