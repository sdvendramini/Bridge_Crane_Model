package combined.djview;
  
public class TestDrive {

    public static void main (String[] args) {
		
    	HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface model1 = new HeartController(heartModel);
        
        BridgeCraneModel bridgeCraneModel = new BridgeCraneModel();
        ControllerInterface model2 = new BridgeCraneController(bridgeCraneModel);
        
        BeatModelInterface beatModel = new BeatModel();
		ControllerInterface model3 = new BeatController(beatModel);
    }
}